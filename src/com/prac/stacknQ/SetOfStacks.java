package com.prac.stacknQ;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

import com.prac.stacknQ.Stack.Node;

/**
 * Stack of plates: Imagine a (literal) stack of plates. If the stack gets too high, it might topple. 
 * Therefore, in real life, we would likely, start a new stack when the previous stack exceeds some threshold.
 * Implement a data structure SetOfStacks that mimics this. 
 * SetOfStacks should be composed of stacks and should create a new stack once the previous one exceeds capacity. 
 * SetOfStacks.push() and SetOfStacks.pop() should behave identically to a single stack 
 * (that is, pop() should return values as it would if there were a just a single stack).
 * FOLLOW UP:
 * Implement a function popAt(int index) which performs a pop operation on a specific sub-stack.
 */
public class SetOfStacks{
	
	private int size;
	private int threshold;
	private List<Stack> listOfStacks;
	private Stack stack;
	
	SetOfStacks(int threshold){
		this.threshold = threshold;
		this.size = 0;
		listOfStacks = new ArrayList<Stack>();
	}
	
	public void push(int data){
		if(size == 0 || size % threshold == 0){
			stack = new Stack();
			stack.push(data);
			listOfStacks.add(stack);
			size++;
		}else{
			stack.push(data);
			size++;
		}
	}
	
	public Integer pop(){
		if(listOfStacks.isEmpty()){
			throw new EmptyStackException();
		}
		int value=listOfStacks.get(listOfStacks.size()-1).pop();
		if(listOfStacks.get(listOfStacks.size()-1).top == null){
			listOfStacks.remove(listOfStacks.size()-1);
		}
		/*Integer value = null;
		if(size / threshold == 0){
			value = listOfStacks.get(0).pop();
			if(listOfStacks.get(0).top == null)
				listOfStacks.remove(0);
			size--;
		}else if(size % threshold == 0){
			value = listOfStacks.get((size / threshold)-1).pop();
			if(listOfStacks.get((size / threshold)-1).top == null)
				listOfStacks.remove((size / threshold)-1);
			size--;
		}else{
			value = listOfStacks.get((size / threshold)).pop();
			if(listOfStacks.get((size / threshold)).top == null)
				listOfStacks.remove((size / threshold));
			size--;
		}*/
		
		return value;
	}
	
	public boolean isEmpty(){
		if(listOfStacks.isEmpty()){
			return true;
		}
		return false;
	}
	
	public Integer popAt(int index){
		Integer value = 0;
		if(isEmpty()){
			throw new EmptyStackException();
		}
		if(index < 0 || listOfStacks.size() < index+1){
			System.out.println("Wrong index entered. Please enter index below "+listOfStacks.size());
			System.exit(0);
		}else{
			// pop the element and then shift all first nodes of each stack after the element to the top of previous stack
			value = listOfStacks.get(index).pop();
			int i = listOfStacks.size()-1;
			Node moveNode = null;
			while(i >= index){
				Node ptr = listOfStacks.get(i).top;
				if(ptr == null){
					// if the node is removed from the last stack which had only one node then remove that stack from the set of stacks
					listOfStacks.remove(i);
					i--;
					break;
				}
				Node prev = ptr;
				if(moveNode != null){
					//moveNode will have first node of last stack iterated
					moveNode.next = listOfStacks.get(i).top;
					listOfStacks.get(i).top = moveNode;
				}
				//navigate through the current stack and find the first node keeping pointer to the node before that
				while(ptr.next !=null){
					prev = ptr;
					ptr = ptr.next;
				}
				moveNode = ptr;
				if(ptr == prev){
					//when there is only one node in last stack, then remove the stack
					listOfStacks.remove(i);
				}else{
					// point next pointer of second node to null to remove first node from the current stack
					prev.next = null;
				}
				i--;
			}
			
		}
		return value;
	}

}
