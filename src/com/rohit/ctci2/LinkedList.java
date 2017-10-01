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

	public LinkedList sumLists(LinkedList l1, LinkedList l2) {

		Node headL1 = l1.head;
		Node headL2 = l2.head;

		int j = 1, n1 = 0;
		while (headL1 != null) {
			n1 = n1 + headL1.getData() * j;
			j = j * 10;
			headL1 = headL1.getNext();
		}

		int k = 1, n2 = 0;
		while (headL2 != null) {
			n2 = n2 + headL2.getData() * k;
			k = k * 10;
			headL2 = headL2.getNext();
		}

		int n = n1 + n2;
		LinkedList l = new LinkedList();
		while (n != 0) {
			l.append(n % 10);
			n = n / 10;

		}
		return l;
	}

	public boolean isPalindrome() {
		Node current = head;
		int i=1;
		Node tail = nthNodeFromEnd(i);
		while(current != tail) {
			if(current.getData() != tail.getData()) {
				return false;
			}
			if(current.getNext() == tail) {
				return true;
			}
			current = current.getNext();
			tail = nthNodeFromEnd(++i);
		}
		return true;
	}
	
	public Node intersection(Node n1, Node n2) {
		Node temp1 = n1;
		Node temp2 = n2;
		
		int l1 = 0, l2 = 0;
		
		while(temp1 != null) {
			l1++;
			temp1 = temp1.getNext();
		}
		
		while(temp2 != null) {
			l2++;
			temp2 = temp2.getNext();
		}
		
		if(temp1 != temp2) {
			return null;
		}
		
		Node temp3 = n1, temp4 = n2;
		if(l1 > l2) {
			for (int i = 0; i < l1-l2; i++) {
				temp3 = temp3.getNext();
			}
		}else if(l1 < l2) {
			for (int i = 0; i < l2-l1; i++) {
				temp4 = temp4.getNext();
			}
		}
		
		while(temp3 != null) {
			if(temp3 == temp4) {
				return temp3;
			}
			temp3 = temp3.getNext();
			temp4 = temp4.getNext();
		}
		return null;
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
