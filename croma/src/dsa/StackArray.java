package dsa;

import java.util.EmptyStackException;

/**
 * Simple stack implementation using a dynamic array.
 */
public class StackArray {
	private int[] data;
	private int size;

	public StackArray() { this(10); }
	public StackArray(int capacity) {
		data = new int[Math.max(1, capacity)];
	}

	public void push(int value) {
		if (size == data.length) grow();
		data[size++] = value;
	}

	public int pop() {
		if (size == 0) throw new EmptyStackException();
		return data[--size];
	}

	public int peek() {
		if (size == 0) throw new EmptyStackException();
		return data[size - 1];
	}

	public boolean isEmpty() { return size == 0; }

	private void grow() {
		int[] next = new int[data.length * 2];
		System.arraycopy(data, 0, next, 0, data.length);
		data = next;
	}

	public static void main(String[] args) {
		StackArray s = new StackArray(2);
		s.push(10); s.push(20); s.push(30);
		System.out.println(s.peek());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
	}
}


