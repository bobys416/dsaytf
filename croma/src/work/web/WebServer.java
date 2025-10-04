package work.web;

import dsa.*;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * Minimal HTTP server exposing DSA operations as REST endpoints.
 * Endpoints:
 * - GET /                      -> HTML UI
 * - GET /api/search/linear     -> ?array=1,2,3&target=2
 * - GET /api/search/binary     -> ?array=1,2,3&target=2 (array must be sorted)
 * - GET /api/sort              -> ?algo=bubble|selection|insertion|merge|quick&array=3,1,2
 */
public class WebServer {
	public static void main(String[] args) throws IOException {
		int port = resolvePort();
		HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);

		server.createContext("/", exchange -> respondHtml(exchange, html()));
		server.createContext("/api/search/linear", new LinearSearchHandler());
		server.createContext("/api/search/binary", new BinarySearchHandler());
		server.createContext("/api/sort", new SortHandler());

		server.setExecutor(null);
		System.out.println("Server running on http://localhost:" + port);
		server.start();
	}

	private static int resolvePort() {
		String fromProp = System.getProperty("port");
		String fromEnv = System.getenv("PORT");
		int def = 8080;
		if (fromProp != null && !fromProp.isBlank()) {
			try { return Integer.parseInt(fromProp.trim()); } catch (Exception ignored) {}
		}
		if (fromEnv != null && !fromEnv.isBlank()) {
			try { return Integer.parseInt(fromEnv.trim()); } catch (Exception ignored) {}
		}
		return def;
	}

	private static class LinearSearchHandler implements HttpHandler {
		@Override public void handle(HttpExchange exchange) throws IOException {
			Map<String, String> q = parseQuery(exchange.getRequestURI().getRawQuery());
			int[] arr = parseIntArray(q.getOrDefault("array", ""));
			int target = parseInt(q.get("target"), 0);
			int idx = LinearSearch.search(arr, target);
			respondJson(exchange, json(Map.of(
				"algorithm", "linear",
				"target", target,
				"index", idx,
				"array", Arrays.toString(arr)
			)));
		}
	}

	private static class BinarySearchHandler implements HttpHandler {
		@Override public void handle(HttpExchange exchange) throws IOException {
			Map<String, String> q = parseQuery(exchange.getRequestURI().getRawQuery());
			int[] arr = parseIntArray(q.getOrDefault("array", ""));
			int target = parseInt(q.get("target"), 0);
			int idx = BinarySearch.search(arr, target);
			respondJson(exchange, json(Map.of(
				"algorithm", "binary",
				"target", target,
				"index", idx,
				"array", Arrays.toString(arr)
			)));
		}
	}

	private static class SortHandler implements HttpHandler {
		@Override public void handle(HttpExchange exchange) throws IOException {
			Map<String, String> q = parseQuery(exchange.getRequestURI().getRawQuery());
			String algo = Optional.ofNullable(q.get("algo")).orElse("bubble").toLowerCase(Locale.ROOT);
			int[] arr = parseIntArray(q.getOrDefault("array", ""));
			int[] copy = Arrays.copyOf(arr, arr.length);
			switch (algo) {
				case "bubble": BubbleSort.sort(copy); break;
				case "selection": SelectionSort.sort(copy); break;
				case "insertion": InsertionSort.sort(copy); break;
				case "merge": MergeSort.sort(copy); break;
				case "quick": QuickSort.sort(copy); break;
				default: BubbleSort.sort(copy); algo = "bubble"; break;
			}
			respondJson(exchange, json(Map.of(
				"algorithm", algo,
				"input", Arrays.toString(arr),
				"output", Arrays.toString(copy)
			)));
		}
	}

	// ----------------- Helpers -----------------
	private static void respondJson(HttpExchange exchange, String body) throws IOException {
		Headers h = exchange.getResponseHeaders();
		h.set("Content-Type", "application/json; charset=utf-8");
		h.set("Access-Control-Allow-Origin", "*");
		byte[] bytes = body.getBytes(StandardCharsets.UTF_8);
		exchange.sendResponseHeaders(200, bytes.length);
		try (OutputStream os = exchange.getResponseBody()) { os.write(bytes); }
	}

	private static void respondHtml(HttpExchange exchange, String body) throws IOException {
		Headers h = exchange.getResponseHeaders();
		h.set("Content-Type", "text/html; charset=utf-8");
		h.set("Access-Control-Allow-Origin", "*");
		byte[] bytes = body.getBytes(StandardCharsets.UTF_8);
		exchange.sendResponseHeaders(200, bytes.length);
		try (OutputStream os = exchange.getResponseBody()) { os.write(bytes); }
	}

	private static String json(Map<String, ?> map) {
		StringBuilder sb = new StringBuilder();
		sb.append('{');
		boolean first = true;
		for (Map.Entry<String, ?> e : map.entrySet()) {
			if (!first) sb.append(',');
			first = false;
			sb.append('"').append(escape(e.getKey())).append('"').append(':');
			Object v = e.getValue();
			if (v == null) {
				sb.append("null");
			} else if (v instanceof Number || v instanceof Boolean) {
				sb.append(v.toString());
			} else {
				sb.append('"').append(escape(v.toString())).append('"');
			}
		}
		sb.append('}');
		return sb.toString();
	}

	private static String escape(String s) {
		return s.replace("\\", "\\\\").replace("\"", "\\\"").replace("\n", "\\n").replace("\r", "\\r");
	}

	private static Map<String, String> parseQuery(String raw) {
		Map<String, String> map = new LinkedHashMap<>();
		if (raw == null || raw.isEmpty()) return map;
		for (String pair : raw.split("&")) {
			int i = pair.indexOf('=');
			if (i >= 0) {
				String k = decode(pair.substring(0, i));
				String v = decode(pair.substring(i + 1));
				map.put(k, v);
			} else {
				map.put(decode(pair), "");
			}
		}
		return map;
	}

	private static String decode(String s) {
		return URLDecoder.decode(s, StandardCharsets.UTF_8);
	}

	private static int[] parseIntArray(String s) {
		if (s == null || s.isBlank()) return new int[0];
		String[] parts = s.split(",");
		int[] out = new int[parts.length];
		for (int i = 0; i < parts.length; i++) out[i] = parseInt(parts[i].trim(), 0);
		return out;
	}

	private static int parseInt(String s, int def) {
		try { return Integer.parseInt(s); } catch (Exception e) { return def; }
	}

	private static String html() {
		return "" +
			"<!doctype html><html lang=\"en\"><head><meta charset=\"utf-8\">" +
			"<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">" +
			"<title>Assignment DSA Web</title>" +
			"<style>body{font-family:Segoe UI,Arial;margin:24px}input,select{padding:6px;margin:4px}code{background:#f4f4f4;padding:2px 4px}pre{background:#f7f7f7;padding:12px;border-radius:6px}section{margin-bottom:24px}</style>" +
			"</head><body>" +
			"<h2>Assignment DSA Web</h2>" +
			"<section><h3>Search</h3>" +
			"<div><label>Array</label><input id=\"arr\" value=\"1,3,4,6,8,10\"><label>Target</label><input id=\"target\" value=\"6\">" +
			"<button onclick=\"linear()\">Linear</button><button onclick=\"binary()\">Binary</button></div>" +
			"<pre id=\"out-search\"></pre></section>" +
			"<section><h3>Sort</h3>" +
			"<div><label>Array</label><input id=\"arr2\" value=\"5,1,4,2,8\">" +
			"<select id=\"algo\"><option>bubble</option><option>selection</option><option>insertion</option><option>merge</option><option>quick</option></select>" +
			"<button onclick=\"sort()\">Sort</button></div>" +
			"<pre id=\"out-sort\"></pre></section>" +
			"<script>" +
			"async function linear(){const a=document.getElementById('arr').value;const t=document.getElementById('target').value;const r=await fetch(`/api/search/linear?array=${encodeURIComponent(a)}&target=${encodeURIComponent(t)}`);document.getElementById('out-search').textContent=JSON.stringify(await r.json(),null,2);}" +
			"async function binary(){const a=document.getElementById('arr').value;const t=document.getElementById('target').value;const r=await fetch(`/api/search/binary?array=${encodeURIComponent(a)}&target=${encodeURIComponent(t)}`);document.getElementById('out-search').textContent=JSON.stringify(await r.json(),null,2);}" +
			"async function sort(){const a=document.getElementById('arr2').value;const algo=document.getElementById('algo').value;const r=await fetch(`/api/sort?algo=${encodeURIComponent(algo)}&array=${encodeURIComponent(a)}`);document.getElementById('out-sort').textContent=JSON.stringify(await r.json(),null,2);}" +
			"</script>" +
			"</body></html>";
	}
}


