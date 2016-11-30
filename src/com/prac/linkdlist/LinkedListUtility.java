package com.prac.linkdlist;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LinkedListUtility {

	/*
	 * Remove Dups: Write code to remove duplicates from an unsorted linked list
	 * without using extra buffer space
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void removeDubWithoutBuffer(LinkedListN list) {
		LinkedListN.Node element = list.first;
		LinkedListN.Node prev = element;

		while (element != null) {
			LinkedListN.Node ptr = element.next;
			prev = element;
			while (ptr != null) {
				if (element.value == ptr.value) {
					prev.next = ptr.next;
					ptr = ptr.next;
				} else {
					prev = ptr;
					ptr = ptr.next;
				}
			}
			element = element.next;
		}

		LinkedListN.Node itr = list.first;

		while (itr != null) {
			System.out.println(itr.value);
			itr = itr.next;
		}
	}

	/*
	 * Remove Dups: Write code to remove duplicates from an unsorted linked list
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void removeDupsWithBuffer(LinkedListN list) {

		List<Object> bufferList = new ArrayList<Object>();
		LinkedListN.Node element = list.first;

		LinkedListN.Node prev = null;

		while (element != null) {
			if (bufferList.contains(element.value)) {
				if (element.next != null) {
					element.value = element.next.value;
					element.next = element.next.next;
					prev = element;

				} else {
					// element = null;
					prev.next = null;
				}

			} else {
				bufferList.add(element.value);
				prev = element;
			}
			element = element.next;
		}

		LinkedListN.Node itr = list.first;

		while (itr != null) {
			System.out.println(itr.value);
			itr = itr.next;
		}
	}

	/*
	 * Return Kth to Mth: Write an algorithm to find kth element before the mth
	 * element of the list from start of the list
	 */
	@SuppressWarnings("rawtypes")
	public static void findKthToMth(int k, int m, LinkedListN list) {
		LinkedListN.Node start = list.first;
		LinkedListN.Node diff = start;

		if (m <= list.size() && k < m && k > 0) {

			int i = 0;
			int d = m - k;
			while (i < d) {
				diff = diff.next;
				i++;
			}

			i = 1;

			while (i < d && diff != null) {
				start = start.next;
				diff = diff.next;
				i++;
			}

			System.out.println("Value of Kth node to Mth node is :: "
					+ start.value);
		} else {
			System.out
					.println("Invalid values for k and m as size of your linked list is = "
							+ list.size());
		}

	}

	/*
	 * Delete Middle Node: Implement an algorithm to delete a node in the middle
	 * (i.e. any node but the first and last node, not necessarily the exact
	 * middle) of a singly linked list, given only access to that node.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void deleteGivenNode(LinkedListN.Node element,
			LinkedListN.Node first) {
		if (element == first || element.next == null) {
			System.out.println("Invalid Node !!");
		}
		element.value = element.next.value;
		element.next = element.next.next;

	}

	/*
	 * Partition: Write code to partition a linked list around a value x, such
	 * that all nodes less than x come before all nodes greater than or equal to
	 * x. If x is contained within the list, the values of x only need to be
	 * after the elements less than x. The partition element x can appear
	 * anywhere in the "right partition"; it does not need to appear between the
	 * left and right partitions.
	 * 
	 * Example- Input :- 3 --> 5 --> 8 --> 5 --> 10 --> 2 --> 1 (partition=5)
	 * Output :- 3 --> 1 --> 2 --> <partition>10 --> 5 --> 5 --> 8 [Not
	 * necessarily in this order]
	 */
	public static void partitionAtX(Integer xNode, LinkedListN<Integer> list) {

		LinkedListN.Node<Integer> element = list.first;
		LinkedListN.Node<Integer> ptr = null, temp = null, start = null;

		while (element != null) {
			if (element == list.first) {
				ptr = element;
				start = element;
				element = element.next;
			} else {
				if (element.value < xNode) {
					ptr.next = element.next;
					temp = element;
					element = element.next;
					temp.next = start;
					start = temp;
				} else {
					ptr = element;
					element = element.next;
				}
			}

		}

		list.first = start;
	}

	/*
	 * Sum Lists: You have two numbers represented by a linked list, where each
	 * node contains a single digit. The digits are stored in reverse order,
	 * such that the 1st digit is at the head of the list. Write a function that
	 * adds the two numbers and returns the sum as linked list.
	 * 
	 * EXAMPLE-
	 * 
	 * Input:- (7 --> 1 --> 6) + (5 --> 9 --> 2). That is, 617+295 = 912
	 * Output:- (2 --> 1 --> 9)
	 */
	public static void sumListsWithUnitDigitFirstElement(
			LinkedListN<Integer> listOne, LinkedListN<Integer> listTwo) {

		if (listOne == null && listTwo == null) {
			if (listOne.first == null && listTwo.first == null) {
				System.out.println("invalid lists");
				return;
			}
		}

		LinkedListN.Node<Integer> ptrToFirst = listOne.first;
		LinkedListN.Node<Integer> ptrToSecond = listTwo.first;

		LinkedListN<Integer> resultList = new LinkedListN<Integer>();
		int sum = 0;
		int carryFwd = 0;

		while (ptrToFirst != null || ptrToSecond != null) {
			sum = carryFwd;
			if (ptrToFirst != null) {
				sum = sum + ptrToFirst.value;
				ptrToFirst = ptrToFirst.next;
			}
			if (ptrToSecond != null) {
				sum = sum + ptrToSecond.value;
				ptrToSecond = ptrToSecond.next;
			}
			if (sum >= 10) {
				carryFwd = sum / 10;
				sum = sum % 10;
			} else {
				carryFwd = 0;
			}
			resultList.add(sum);
			sum = 0;
		}

		System.out
				.println(" Final result is sumListsWithUnitDigitFirstElement : ");

		displayLinkedList(resultList);

	}

	/*
	 * Sum Lists: You have two numbers represented by a linked list, where each
	 * node contains a single digit. The digits are stored in forward order,
	 * such that the 1st digit is at the start of the list. Write a function
	 * that adds the two numbers and returns the sum as linked list.
	 * 
	 * EXAMPLE-
	 * 
	 * Input:- (6 --> 1 --> 7) + (2 --> 9 --> 5). That is, 617+295 = 912
	 * Output:- (9 --> 1 --> 2)
	 */
	public static void sumListsWithHundredthDigitFirstElement(
			LinkedListN<Integer> listOne, LinkedListN<Integer> listTwo) {

		LinkedListN.Node<Integer> ptrToFirst = listOne.first;
		LinkedListN.Node<Integer> ptrToSecond = listTwo.first;

		while (ptrToFirst != null || ptrToSecond != null) {
			if (ptrToFirst == null) {
				listOne.addAtFirst(0);
			} else if (ptrToSecond == null) {
				listTwo.addAtFirst(0);
			}
			if (ptrToFirst != null) {
				ptrToFirst = ptrToFirst.next;
			}
			if (ptrToSecond != null) {
				ptrToSecond = ptrToSecond.next;
			}
		}

		ptrToFirst = listOne.first;
		ptrToSecond = listTwo.first;
		LinkedListN<Integer> resultList = new LinkedListN<Integer>();
		int carryFwd = getSum(ptrToFirst, ptrToSecond, resultList);
		if (carryFwd != 0) {
			resultList.add(carryFwd);
		}
		System.out
				.println(" Final result is sumListsWithHundredthDigitFirstElement : ");
		displayLinkedList(resultList);
	}

	public static int getSum(LinkedListN.Node<Integer> ptrToFirst,
			LinkedListN.Node<Integer> ptrToSecond,
			LinkedListN<Integer> resultList) {
		int carryFwd = 0;

		if (ptrToFirst != null && ptrToSecond != null) {
			carryFwd = getSum(ptrToFirst.next, ptrToSecond.next, resultList);
		} else {
			return 0;
		}

		int sum = carryFwd + ptrToFirst.value + ptrToSecond.value;
		carryFwd = sum / 10;
		sum = sum % 10;
		resultList.addAtFirst(sum);
		return carryFwd;
	}

	/*
	 * Pallindrome : Implement a function to check if linked list is a
	 * pallindrome.
	 */
	public static boolean isPallindromeWithBuffer(LinkedListN<Integer> list) {
		boolean isPallindrome = false;
		LinkedListN.Node<Integer> slowRunner = list.first;
		LinkedListN.Node<Integer> fastRunner = slowRunner;

		Stack<Integer> stack = new Stack<Integer>();
		while (fastRunner != null && fastRunner.next != null) {
			stack.push(slowRunner.value);
			slowRunner = slowRunner.next;
			fastRunner = fastRunner.next.next;
		}

		if (fastRunner != null)
			slowRunner = slowRunner.next;

		while (slowRunner != null) {
			int value = stack.pop();
			if (value == slowRunner.value) {
				isPallindrome = true;
			} else {
				isPallindrome = false;
			}
			slowRunner = slowRunner.next;
		}
		return isPallindrome;
	}

	/*
	 * Intersection: Given two singly linked lists, determine if the two lists
	 * intersect. Return the intersecting node. Note that the intersection is
	 * defined based on reference, not value. That is, if the kth node of the
	 * first linked list is the exact same node (by reference) as the jth node
	 * of the second linked list, then they are intersecting.
	 */
	public static LinkedListN.Node<Integer> findIntersection(
			LinkedListN<Integer> listOne, LinkedListN<Integer> listTwo) {
		LinkedListN.Node<Integer> intersectionNode = null;

		LinkedListN.Node<Integer> ptrToFirst = listOne.first;
		LinkedListN.Node<Integer> ptrToSecond = listTwo.first;

		int size1 = 0;
		int size2 = 0;

		while (ptrToFirst != null || ptrToSecond != null) {
			if (ptrToFirst != null) {
				size1++;
				ptrToFirst = ptrToFirst.next;
			}
			if (ptrToSecond != null) {
				size2++;
				ptrToSecond = ptrToSecond.next;
			}
		}

		ptrToFirst = listOne.first;
		ptrToSecond = listTwo.first;

		// int d = 0;
		if (size1 < size2) {
			int d = size2 - size1;
			for (int i = 0; i < d; i++) {
				ptrToSecond = ptrToSecond.next;
			}
			intersectionNode = getIntersectingNodeOfEqualLengthLists(
					ptrToFirst, ptrToSecond);
		} else if (size2 < size1) {
			int d = size1 - size2;
			for (int i = 0; i < d; i++) {
				ptrToFirst = ptrToFirst.next;
			}
			intersectionNode = getIntersectingNodeOfEqualLengthLists(
					ptrToFirst, ptrToSecond);
		} else {
			intersectionNode = getIntersectingNodeOfEqualLengthLists(
					ptrToFirst, ptrToSecond);
		}

		return intersectionNode;
	}

	public static LinkedListN.Node<Integer> getIntersectingNodeOfEqualLengthLists(
			LinkedListN.Node<Integer> pntrToFirst,
			LinkedListN.Node<Integer> pntrToSecond) {
		LinkedListN.Node<Integer> intersectionNode = null;

		while (pntrToFirst != null && pntrToSecond != null) {
			if (pntrToFirst == pntrToSecond) {
				intersectionNode = pntrToFirst;
				return intersectionNode;
			}
			pntrToFirst = pntrToFirst.next;
			pntrToSecond = pntrToSecond.next;
		}

		return intersectionNode;
	}

	public static void getIntersectingNode(LinkedListN<Integer> listOne, LinkedListN<Integer> listTwo) {
		
		LinkedListN.Node<Integer> ptrToListOne = listOne.first;
		
		while(ptrToListOne.next != null){
			ptrToListOne = ptrToListOne.next;
		}
		
		ptrToListOne.next = listOne.first;
		//displayLinkedList(listOne);
		LinkedListN.Node<Integer> node = checkLoopWithOutBuffer(listTwo);
		
		if(node != null){
			System.out.println("Intersecting node is : "+node.value);
		}else{
			System.out.println("No intersection");
		}
		
	}

	/*
	 * Loop Detection: Given a circular linked list, implement an algorithm that
	 * returns the node at the beginning of the loop.
	 */
	public static boolean checkLoopWithBuffer(LinkedListN<Integer> list) {
		boolean hasLoop = false;
		List<LinkedListN.Node<Integer>> buffer = new ArrayList<LinkedListN.Node<Integer>>();
		LinkedListN.Node<Integer> pointer = list.first;
		while (pointer != null) {
			if (buffer.contains(pointer)) {
				hasLoop = true;
				break;
			} else {
				buffer.add(pointer);
				hasLoop = false;
			}
			pointer = pointer.next;
		}
		return hasLoop;
	}

	/*
	 * Loop Detection: Given a circular linked list, implement an algorithm that
	 * returns the node at the beginning of the loop.
	 */
	public static LinkedListN.Node<Integer> checkLoopWithOutBuffer(LinkedListN<Integer> list) {
		
		LinkedListN.Node<Integer> node = null;
		boolean hasLoop = false;

		LinkedListN.Node<Integer> slow = list.first;
		LinkedListN.Node<Integer> fast = slow.next;

		while (fast != null && fast.next != null) {
			if (slow == fast) {
				hasLoop = true;
				break;
			} 
			fast = fast.next.next;
			slow = slow.next;
		}
		
		 if (hasLoop) {
	            slow = list.first;
	            while (slow != fast.next) {
	                slow = slow.next;
	                fast = fast.next;
	            }
	            node = fast.next;
	            System.out.println("loop at : " + fast.next.value);
	        }
		

		return node;
	}

	/**
	 * utility method to display linked list
	 * 
	 * @param resultList
	 */
	@SuppressWarnings("rawtypes")
	public static void displayLinkedList(LinkedListN resultList) {
		LinkedListN.Node ptr = resultList.first;
		while (ptr != null) {
			System.out.print(ptr.value + " --> ");
			ptr = ptr.next;
		}
		System.out.print("null");
		System.out.println();
	}
}
