package com.prac.stacknQ;

import com.prac.stacknQ.animalShelter.Animal;
import com.prac.stacknQ.animalShelter.Cat;
import com.prac.stacknQ.animalShelter.Dog;


public class StackNQueueMain {

	public static void main(String[] args) {
		/*
		 * Three stacks in one: Describe how could you use single array for three stacks.
		 */
		//multistack();
		
		/*
		 * Stack Min: How would you design a stack which, in addition to push and pop, 
		 * has a function min which returns the minimum element?
		 * Push, Pop and min should all operate in O(1) time.
		 */
		//stackMin(); // contains min variable with each node
		//stackMinWithAuxilaryStack();  // creates two stacks - one to store elements and another to store min , worst case when adding values in descending order
		
		/*
		 * Stack of plates: Imagine a (literal) stack of plates. If the stack gets too high, it might topple. 
		 * Therefore, in real life, we would likely, start a new stack when the previous stack exceeds some threshold.
		 * Implement a data structure SetOfStacks that mimics this. 
		 * SetOfStacks should be composed of stacks and should create a new stack once the previous one exceeds capacity. 
		 * SetOfStacks.push() and SetOfStacks.pop() should behave identically to a single stack 
		 * (that is, pop() should return values as it would if there were a just a single stack).
		 * FOLLOW UP:
		 * Implement a function popAt(int index) which performs a pop operation on a specific sub-stack.
		 */
		//StackOfPlates();
		
		/*
		 * Queue via Stacks: Implement a MyQueue class which implements a queue using two stacks.
		 */
		
		
		/*
		 * Write a program to sort a stack in ascending order (with
		 * biggest items on top). You may use at most one additional
		 * stack to hold items, but you may not copy the elements into
		 * any other data structure (such as an array). The stack supports
		 * the following operations: push, pop, peek, and isEmpty.
		 */
		//SortAStack();
		
		/*
		 * An animal shelter holds only dogs and cats, and operates on a strictly
		 * "first in, first out" basis. People must adopt either the "oldest"
		 * (based on arrival time) of all animals at the shelter, or they can
		 * select whether they would prefer a dog or a cat (and will receive
		 * the oldest animal of that type). They cannot select which specific
		 * animal they would like. Create the data structures to maintain this
		 * system and implement operations such as enqueue, dequeueAny, dequeueDog
		 * and dequeueCat.You may use the built-in LinkedList data structure.
		 */
		animalShelter();
	}
	
	private static void animalShelter(){
		Queue<Animal> queue = new Queue<Animal>();
		queue.enqueue(new Cat());
		queue.enqueue(new Dog());
		queue.enqueue(new Cat());
		queue.enqueue(new Dog());
		queue.enqueue(new Cat());
		queue.enqueue(new Dog());
		
		queue.dequeueAny().makeSound();
		queue.dequeueAny().makeSound();
		queue.dequeueDog().makeSound();
		queue.dequeueCat().makeSound();
		System.out.println();
		
		while(queue.first != null){
			queue.first.data.makeSound();
			queue.first = queue.first.next;
		}
	}
	
	private static void SortAStack(){
		Stack stack = new Stack();
		stack.push(3);
		stack.push(4);
		stack.push(2);
		stack.push(5);
		stack.push(6);
		stack.push(1);
		stack.push(9);
		
		StackNQueueUtil.sort(stack);
		display(stack);
	}
	
	private static void StackOfPlates() {
		SetOfStacks setOfStacks = new SetOfStacks(4);
		setOfStacks.push(2);
		setOfStacks.push(3);
		setOfStacks.push(7);
		setOfStacks.push(5);
		setOfStacks.push(4);
		setOfStacks.push(8);
		setOfStacks.push(9);
		
		System.out.println(setOfStacks.pop());
		System.out.println(setOfStacks.pop());
		System.out.println(setOfStacks.pop());
	/*	System.out.println(setOfStacks.pop());
		System.out.println(setOfStacks.pop());
		System.out.println(setOfStacks.pop());*/
		System.out.println(setOfStacks.popAt(0));
		System.out.println(setOfStacks.popAt(0));
		System.out.println(setOfStacks.popAt(0));
	}

	public static void multistack(){
		Multistack stack = new Multistack(3,3);
		//System.out.println(stack.isEmpty(3));
		//System.out.println(stack.pop(2));
		stack.push(3, 1);
		for(int i = 0; i<3*3; i++){
			System.out.print(stack.values[i]+" ");
		}
		System.out.println();
		stack.push(4, 2);
		stack.push(7, 2);
		stack.push(8, 2);
		for(int i = 0; i<3*3; i++){
			System.out.print(stack.values[i]+" ");
		}
		System.out.println();
		stack.push(5, 3);
		for(int i = 0; i<3*3; i++){
			System.out.print(stack.values[i]+" ");
		}
		System.out.println();
		System.out.println("Peek from stack 1 = "+stack.peek(1));
		System.out.println("Pop from stack 2 = "+stack.pop(2));
		for(int i = 0; i<3*3; i++){
			System.out.print(stack.values[i]+" ");
		}
	}
	
	public static void stackMin(){
		StackWithMin stack = new StackWithMin();
		stack.push(6);
		stack.push(4);
		stack.push(8);
		stack.push(3);
		stack.push(9);
		stack.push(1);
		
		//displayStackWithMin(stack);
		
		System.out.println("Minimum = "+stack.min());
		System.out.println("Popped = "+stack.pop());
		System.out.println("Minimum after pop = "+stack.min());
		stack.pop();
		stack.pop();
		System.out.println("Minimum after 3 elements pop = "+stack.min());
	}
	
	public static void stackMinWithAuxilaryStack(){
		StackMinWithAuxilaryStack stack = new StackMinWithAuxilaryStack();
		stack.push(6);
		stack.push(4);
		stack.push(2);
		stack.push(8);
		stack.push(2);
		stack.push(3);
		stack.push(9);
		stack.push(1);
		
		System.out.println("Minimum = "+stack.min());
		System.out.println("Popped = "+stack.pop());
		System.out.println("Minimum after pop = "+stack.min());
		stack.pop();
		stack.pop();
		stack.pop();
		System.out.println("Minimum after 3 elements pop = "+stack.min());
		
	}
	
	public static void displayStackWithMin(StackWithMin stack){
		while(stack.top != null){
			System.out.println(stack.top.data);
			stack.top = stack.top.prev;
		}
	}
	
	public static void display(Stack stack){
		while(stack.top != null){
			System.out.println(stack.top.data);
			stack.top = stack.top.next;
		}
	}
	
}
