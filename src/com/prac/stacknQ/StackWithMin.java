package com.prac.stacknQ;

import java.util.EmptyStackException;

/**
 * Stack Min: How would you design a stack which, in addition to push and pop, 
 * has a function min which returns the minimum element?
 * Push, Pop and min should all operate in O(1) time.
 */
public class StackWithMin {
	
	public static class Stack{
		int data;
		int min;
		Stack prev;
		Stack(int data, int min, Stack next){
			this.data = data;
			this.min = min;
			this.prev = next;
		}
	}
	
	public Stack top;
	
	public void push(int data){
		Stack current = null;
		if(top == null){
			current = new Stack(data,data, null);
			top = current;
		}else{
			if(top.min < data){
				current = new Stack(data,top.min, null);
			}else{
				current = new Stack(data,data, null);
			}
			current.prev = top;
			top = current;
		}
	}
	
	public int pop(){
		int value = 0;
		if(top == null){
			throw new EmptyStackException();
		}
		value = top.data;
		top = top.prev;
		return value;
	}
	
	public int min(){
		int value = 0;
		if(top == null){
			throw new EmptyStackException();
		}
		value = top.min;
		return value;
	}
	 
	public boolean isEmpty(){
		if(top == null){
			return true;
		}
		return false;
	}
}
