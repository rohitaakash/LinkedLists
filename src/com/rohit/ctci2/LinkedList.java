package com.rohit.ctci2;

import java.util.HashMap;
import java.util.HashSet;

public class LinkedList {

	private Node head;

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	public void append(int data) {
		if (head == null) {
			head = new Node(data);
			return;
		}

		Node current = head;
		while (current.getNext() != null) {
			current = current.getNext();
		}

		current.setNext(new Node(data));
	}

	public void prepend(int data) {
		Node newNode = new Node(data);
		newNode.setNext(head);
		head = newNode;

	}

	public void deleteWithData(int data) {
		if (head == null)
			return;

		if (head.getData() == data) {
			head = head.getNext();
			return;
		}

		Node current = head;
		while (current.getNext() != null) {
			if (current.getNext().getData() == data) {
				current.setNext(current.getNext().getNext());
				return;
			}
			current = current.getNext();
		}
	}

	public void removeDuplicates() {

		HashSet<Integer> unique = new HashSet<Integer>();
		Node previous = null;
		Node current = head;

		while (current.getNext() != null) {
			if (unique.contains(current.getData())) {
				previous.setNext(current.getNext());
			} else {
				unique.add(current.getData());
				previous = current;
			}
			current = current.getNext();
		}
	}

	public void deleteNodeByPosition(int k) {
		Node counterNode = head;
		int length = 0;

		if (head == null)
			return;

		while (counterNode != null) {
			length++;
			counterNode = counterNode.getNext();
		}

		if (k > length)
			return;

		Node current = head;
		for (int i = 1; i < k - 1; i++) {
			current = current.getNext();
		}

		current.setNext(current.getNext().getNext());
	}

	public void partitionByValue(int x) {
		Node current = head;
		Node lPart = null;
		Node rPart = null;
		Node headRPart = null;
		Node headLPart = null;
		Node temp = head;

		while (temp != null) {
			current = temp;
			temp = temp.getNext();
			if (current.getData() < x) {
				if (lPart == null) {
					headLPart = current;
					headLPart.setNext(null);
					lPart = headLPart;
				} else {
					lPart.setNext(current);
					lPart = lPart.getNext();
					lPart.setNext(null);
				}
			} else if (current.getData() >= x) {
				if (rPart == null) {
					headRPart = current;
					headRPart.setNext(null);
					rPart = headRPart;
				} else {
					rPart.setNext(current);
					rPart = rPart.getNext();
					rPart.setNext(null);
				}
			}

		}
		head = headLPart;
		lPart.setNext(headRPart);
	}

	public Node sumLists(LinkedList l1, LinkedList l2) {
		int n1 = 1, i = 0;
		while (l1.head.getNext() != null) {
			n1 = n1 * i + l1.head.getData();
			l1.head = l1.head.getNext();
			i = i * 10;
		}

		int n2 = 1, j = 0;
		while (l2.head.getNext() != null) {
			n2 = n2 * j + l2.head.getData();
			l2.head = l2.head.getNext();
			j = j * 10;
		}

		int n = n1 + n2, k = 10;
		LinkedList l = new LinkedList();

		while (n != 0) {
			l.head.setData(n / k);
			l.head.setNext(null);
			k = k * 10;

		}

		return new Node();

	}

	public Node nthNodeFromEnd(int n) {
		Node current = head;
		Node temp = head;

		for (int i = 0; i < n; i++) {
			if (current != null) {
				current = current.getNext();
			}
		}

		while (current != null) {
			temp = temp.getNext();
			current = current.getNext();
		}

		return temp;
	}

	/*
	 * Brute-Force public Node checkCircular() { Node current = head; Node loop =
	 * head;
	 * 
	 * while(current != null) { loop = current; while(loop != null) {
	 * if(loop.getNext() == current) { return loop; } loop = loop.getNext(); }
	 * current = current.getNext(); } return null; }
	 */

	public Node checkCircular() {
		HashMap<Node, Integer> unique = new HashMap<>();
		Node current = head;

		while (current != null) {
			if (unique.containsKey(current)) {
				return current;
			} else {
				unique.put(current, current.getData());
			}
			current = current.getNext();
		}

		return null;
	}

	public void listToString() {
		Node temp = head;
		while (temp != null) {
			if (temp.getNext() != null) {
				System.out.print(temp.getData() + "->");
			} else {
				System.out.print(temp.getData());
			}
			temp = temp.getNext();
		}
		System.out.println();
	}
}
