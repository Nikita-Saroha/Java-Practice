package com.prac.stacknQ;

import java.util.EmptyStackException;

/**
 * Three stacks in one: Describe how could you use single array for three stacks.
 */
public class Multistack {
	
	int capacity;
	//int sizeOfStack;
	int noOfStacks;
	int values[];
	int size[];
	
	Multistack(int sizeOfStack, int noOfStacks){
		this.capacity = sizeOfStack;
		this.noOfStacks = noOfStacks;
		values = new int[sizeOfStack*noOfStacks];
		size = new int[noOfStacks];
	}
	
	public int pop(int stackNo){
		int data = 0;
		if(size[stackNo-1] == 0){
			throw new EmptyStackException();
		}
		int position = capacity * (stackNo-1);
		position = (size[stackNo-1]-1)+position;
		data = values[position];
		values[position] = 0;
		size[stackNo-1]--;
		return data;
	}
	
	public void push(int data, int stackNo){
		if(size[stackNo-1] == capacity){
			System.out.println("Stack is full!!");
			return;
		}
		int position = capacity * (stackNo-1);
		values[position+size[stackNo-1]] = data;
		size[stackNo-1]++;
	}
	
	public int peek(int stackNo){
		int data = 0;
		if(size[stackNo-1] == 0){
			throw new EmptyStackException();
		}
		data = values[size[stackNo-1]-1];
		return data;
	}
	
	public boolean isEmpty(int stackNo){
		boolean isEmpty = false;
		if(size[stackNo-1] == 0){
			isEmpty = true;
		}
		return isEmpty;
		
	}
}
