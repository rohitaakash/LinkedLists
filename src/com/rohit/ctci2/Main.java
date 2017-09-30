package com.rohit.ctci2;

public class Main {

	public static void main(String[] args) {

		LinkedList l1 = new LinkedList();
		
		l1.append(200);
		l1.append(105);
		l1.append(45);
		l1.prepend(57);
		l1.append(200);
		l1.append(45);
		l1.append(23);
		
		l1.listToString();
		
		l1.removeDuplicates();
		l1.listToString();
		
		l1.deleteWithData(57);
		l1.listToString();
		
		l1.deleteNodeByPosition(2);
		l1.listToString();
		
		l1.append(63);
		l1.append(29);
		l1.append(117);
		l1.listToString();
		
		l1.partitionByValue(63);
		l1.listToString();
	}

}
