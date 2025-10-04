package dsa;

/**
 * Minimal singly linked list with basic operations.
 */
public class SinglyLinkedList {
	private static class Node {
		int value;
		Node next;

		Node(int value) { this.value = value; }
	}

	private Node head;

	/** Adds a value at the end of the list. */
	public void addLast(int value) {
		Node node = new Node(value);
		if (head == null) { head = node; return; }
		Node cur = head;
		while (cur.next != null) cur = cur.next;
		cur.next = node;
	}

	/** Deletes the first occurrence of the given value. */
	public boolean deleteFirst(int value) {
		if (head == null) return false;
		if (head.value == value) { head = head.next; return true; }
		Node cur = head;
		while (cur.next != null && cur.next.value != value) cur = cur.next;
		if (cur.next == null) return false;
		cur.next = cur.next.next;
		return true;
	}

	/** Returns string representation of the list. */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Node cur = head;
		while (cur != null) {
			sb.append(cur.value);
			if (cur.next != null) sb.append(" -> ");
			cur = cur.next;
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		SinglyLinkedList list = new SinglyLinkedList();
		list.addLast(1);
		list.addLast(2);
		list.addLast(3);
		System.out.println("List: " + list);
		list.deleteFirst(2);
		System.out.println("After delete 2: " + list);
	}
}


