package dsa;

/**
 * Circular queue implementation using an array.
 */
public class QueueArray {
	private int[] data;
	private int head;
	private int tail;
	private int size;

	public QueueArray() { this(8); }
	public QueueArray(int capacity) { data = new int[Math.max(1, capacity)]; }

	public void offer(int value) {
		if (size == data.length) grow();
		data[tail] = value;
		tail = (tail + 1) % data.length;
		size++;
	}

	public int poll() {
		if (size == 0) throw new IllegalStateException("Queue is empty");
		int val = data[head];
		head = (head + 1) % data.length;
		size--;
		return val;
	}

	public boolean isEmpty() { return size == 0; }

	private void grow() {
		int[] next = new int[data.length * 2];
		for (int i = 0; i < size; i++) next[i] = data[(head + i) % data.length];
		data = next;
		head = 0; tail = size;
	}

	public static void main(String[] args) {
		QueueArray q = new QueueArray(3);
		q.offer(1); q.offer(2); q.offer(3); q.offer(4);
		while (!q.isEmpty()) System.out.println(q.poll());
	}
}


