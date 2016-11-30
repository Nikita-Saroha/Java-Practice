package com.prac.linkdlist;

public class LikedListMain {

	public static void main(String[] args) {
		/*
		 * Remove Dups: Write code to remove duplicates from an unsorted linked
		 * list without using extra buffer space
		 */
		// removeDupsBuffer();

		/*
		 * Remove Dups: Write code to remove duplicates from an unsorted linked
		 * list
		 */
		// removeDupsNoBuffer();

		/*
		 * Return Kth to Mth: Write an algorithm to find kth element before the
		 * mth element of the list from start of the list
		 */
		// returnKthToMth();

		/*
		 * Delete Middle Node: Implement an algorithm to delete a node in the
		 * middle (i.e. any node but the first and last node, not necessarily
		 * the exact middle) of a singly linked list, given only access to that
		 * node.
		 */
		//deleteMiddleNode();

		/*
		 * Partition: Write code to partition a linked list around a value x,
		 * such that all nodes less than x come before all nodes greater than or
		 * equal to x. If x is contained within the list, the values of x only
		 * need to be after the elements less than x. The partition element x
		 * can appear anywhere in the "right partition"; it does not need to
		 * appear between the left and right partitions.
		 * 
		 * Example- Input :- 3 --> 5 --> 8 --> 5 --> 10 --> 2 --> 1
		 * (partition=5) Output :- 3 --> 1 --> 2 --> <partition>10 --> 5 --> 5
		 * --> 8 [Not necessarily in this order]
		 */
		 //partition();

		/*
		 * Sum Lists: You have two numbers represented by a linked list, where
		 * each node contains a single digit. The digits are stored in reverse
		 * order, such that the 1st digit is at the head of the list. Write a
		 * function that adds the two numbers and returns the sum as linked
		 * list.
		 * 
		 * EXAMPLE-
		 * 
		 * Input:- (7 --> 1 --> 6) + (5 --> 9 --> 2). That is, 617+295 = 912
		 * Output:- (2 --> 1 --> 9)
		 */
		 //sumListsReverseOrder();

		/*
		 * Sum Lists: You have two numbers represented by a linked list, where
		 * each node contains a single digit. The digits are stored in forward
		 * order, such that the 1st digit is at the start of the list. Write a
		 * function that adds the two numbers and returns the sum as linked
		 * list.
		 * 
		 * EXAMPLE-
		 * 
		 * Input:- (6 --> 1 --> 7) + (2 --> 9 --> 5). That is, 617+295 = 912
		 * Output:- (9 --> 1 --> 2)
		 */
		// sumListsForwardOrder();

		/*
		 * Pallindrome : Implement a function to check if linked list is a
		 * pallindrome.
		 */
		// pallindrome();

		/*
		 * Intersection: Given two singly linked lists, determine if the two
		 * lists intersect. Return the intersecting node. Note that the
		 * intersection is defined based on reference, not value. That is, if
		 * the kth node of the first linked list is the exact same node (by
		 * reference) as the jth node of the second linked list, then they are
		 * intersecting.
		 */
		 intersection();

		/*
		 * Loop Detection: Given a circular linked list, implement an algorithm
		 * that returns the node at the beginning of the loop.
		 */
		 //loopDetection();
	}

	public static void removeDupsBuffer() {
		LinkedListN<String> list = new LinkedListN<String>();
		list.add("Nikita");
		list.add("Amar");
		list.add("Sudhakar");
		list.add("Nikita");

		System.out.println("Before removal of duplicates:");
		LinkedListUtility.displayLinkedList(list);
		System.out.println("After:");
		LinkedListUtility.removeDupsWithBuffer(list);
	}

	public static void removeDupsNoBuffer() {
		LinkedListN<String> list = new LinkedListN<String>();
		list.add("Nikita");
		list.add("Amar");
		list.add("Sudhakar");
		list.add("Nikita");

		System.out.println("Before removal of duplicates:");
		LinkedListUtility.displayLinkedList(list);
		System.out.println("After:");
		LinkedListUtility.removeDubWithoutBuffer(list);

	}

	public static void returnKthToMth() {
		LinkedListN<String> list = new LinkedListN<String>();
		list.add("Nikita");
		list.add("Amar");
		list.add("Sudhakar");
		list.add("Nikita");
		list.add("Saroha");

		int k = 2;
		int m = 5;
		LinkedListUtility.displayLinkedList(list);
		System.out.println("k = " + k + " & m = " + m);
		LinkedListUtility.findKthToMth(k, m, list);
	}

	public static void deleteMiddleNode() {
		LinkedListN<String> list = new LinkedListN<String>();
		list.add("Nikita");
		list.add("Amar");
		list.add("Sudhakar");
		list.add("Nikita");
		list.add("Saroha");

		LinkedListN.Node<String> ptr = list.first;

		while (ptr != null) {
			if (!ptr.value.equals("Amar"))
				ptr = ptr.next;
			else
				break;
		}

		System.out.println("Before deleting node with value : " + ptr.value);
		LinkedListUtility.displayLinkedList(list);
		System.out.println("After deletion:");
		LinkedListUtility.deleteGivenNode(ptr, list.first);
		LinkedListUtility.displayLinkedList(list);
	}

	public static void partition() {
		LinkedListN<Integer> listOfInt = new LinkedListN<Integer>();
		listOfInt.add(7);
		listOfInt.add(3);
		listOfInt.add(5);
		listOfInt.add(8);
		listOfInt.add(5);
		listOfInt.add(10);
		listOfInt.add(2);
		listOfInt.add(1);
		
		int x = 5;
		System.out.println("Before partitioning at x = "+5);
		LinkedListUtility.displayLinkedList(listOfInt);
		System.out.println();
		System.out.println("After partion:");
		LinkedListUtility.partitionAtX(x, listOfInt);
		LinkedListUtility.displayLinkedList(listOfInt);
	}

	public static void sumListsReverseOrder() {
		LinkedListN<Integer> firstNumber = new LinkedListN<Integer>();
		firstNumber.add(7);
		firstNumber.add(1);
		firstNumber.add(6);

		LinkedListN<Integer> secondNumber = new LinkedListN<Integer>();
		secondNumber.add(5);
		secondNumber.add(9);
		secondNumber.add(2);
		// secondNumber.add(2);
		System.out.println("First number :");
		LinkedListUtility.displayLinkedList(firstNumber);
		System.out.println();
		System.out.println("Second number :");
		LinkedListUtility.displayLinkedList(secondNumber);
		System.out.println();
		LinkedListUtility.sumListsWithUnitDigitFirstElement(firstNumber,
				secondNumber);
	}

	public static void sumListsForwardOrder() {
		LinkedListN<Integer> firstNumber = new LinkedListN<Integer>();
		firstNumber.add(7);
		firstNumber.add(1);
		firstNumber.add(6);

		LinkedListN<Integer> secondNumber = new LinkedListN<Integer>();
		secondNumber.add(5);
		secondNumber.add(9);
		secondNumber.add(2);
		// secondNumber.add(2);
		
		System.out.println("First number :");
		LinkedListUtility.displayLinkedList(firstNumber);
		System.out.println();
		System.out.println("Second number :");
		LinkedListUtility.displayLinkedList(secondNumber);
		System.out.println();
		LinkedListUtility.sumListsWithHundredthDigitFirstElement(firstNumber,
				secondNumber);
	}

	public static void pallindrome() {
		LinkedListN<Integer> secondNumber = new LinkedListN<Integer>();
		secondNumber.add(5);
		secondNumber.add(9);
		secondNumber.add(9);
		secondNumber.add(5);
		boolean isPallindrom = LinkedListUtility.isPallindromeWithBuffer(secondNumber);
		System.out.println("List is pallindrome = "+isPallindrom);
		LinkedListUtility.displayLinkedList(secondNumber);
	}

	public static void intersection() {
		LinkedListN.Node<Integer> node1 = new LinkedListN.Node<Integer>(1, null);
		LinkedListN.Node<Integer> node2 = new LinkedListN.Node<Integer>(2, null);
		LinkedListN.Node<Integer> node3 = new LinkedListN.Node<Integer>(3, null);
		LinkedListN.Node<Integer> node4 = new LinkedListN.Node<Integer>(4, null);
		LinkedListN.Node<Integer> node5 = new LinkedListN.Node<Integer>(5, null);
		LinkedListN.Node<Integer> node6 = new LinkedListN.Node<Integer>(6, null);
		LinkedListN.Node<Integer> node7 = new LinkedListN.Node<Integer>(7, null);
		LinkedListN.Node<Integer> node8 = new LinkedListN.Node<Integer>(8, null);

		LinkedListN<Integer> list1 = new LinkedListN<Integer>();
		list1.addNodeAtEnd(node1);
		list1.addNodeAtEnd(node2);
		list1.addNodeAtEnd(node3);
		list1.addNodeAtEnd(node4);
		list1.addNodeAtEnd(node6);
		list1.addNodeAtEnd(node7);
		list1.addNodeAtEnd(node8);

		LinkedListN<Integer> list2 = new LinkedListN<Integer>();
		list2.addNodeAtEnd(node5);
		list2.addNodeAtEnd(node6);
		list2.addNodeAtEnd(node7);
		list2.addNodeAtEnd(node8);
		
		System.out.println("First list:");
		LinkedListUtility.displayLinkedList(list1);
		System.out.println("Second list:");
		LinkedListUtility.displayLinkedList(list2);
		
		LinkedListUtility.getIntersectingNode(list1, list2);
		
		/*LinkedListN.Node<Integer> intersection = LinkedListUtility
				.findIntersection(list1, list2);
		if (intersection != null) {
			System.out.println("Node of intersection is " + intersection.value);
		} else {
			System.out.println("Parallel lists");
		}*/
	}

	public static void loopDetection() {

		LinkedListN.Node<Integer> node1 = new LinkedListN.Node<Integer>(1, null);
		LinkedListN.Node<Integer> node2 = new LinkedListN.Node<Integer>(2, null);
		LinkedListN.Node<Integer> node3 = new LinkedListN.Node<Integer>(3, null);
		LinkedListN.Node<Integer> node4 = new LinkedListN.Node<Integer>(4, null);
		LinkedListN.Node<Integer> node5 = new LinkedListN.Node<Integer>(5, null);
		LinkedListN.Node<Integer> node6 = new LinkedListN.Node<Integer>(6, null);
		LinkedListN.Node<Integer> node7 = new LinkedListN.Node<Integer>(7, null);
		LinkedListN.Node<Integer> node8 = new LinkedListN.Node<Integer>(8, null);

		LinkedListN<Integer> list = new LinkedListN<Integer>();
		list.addNodeAtEnd(node1);
		list.addNodeAtEnd(node2);
		list.addNodeAtEnd(node3);
		list.addNodeAtEnd(node4);
		list.addNodeAtEnd(node6);
		list.addNodeAtEnd(node7);
		list.addNodeAtEnd(node4);

		/*System.out.println("Does this linked list contains loop? "
				+ LinkedListUtility.checkLoopWithBuffer(list) + " .");*/
		System.out.println("Does this linked list contains loop? "
				+ (LinkedListUtility.checkLoopWithOutBuffer(list)!= null ? true : false) + " .");
		System.out.println();
		//LinkedListUtility.displayLinkedList(list);
	}
}
