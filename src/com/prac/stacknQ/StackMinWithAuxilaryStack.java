package com.prac.stacknQ;

import java.util.EmptyStackException;

/**
 * Stack Min: How would you design a stack which, in addition to push and pop, 
 * has a function min which returns the minimum element?
 * Push, Pop and min should all operate in O(1) time.
 */
public class StackMinWithAuxilaryStack {
	
	public static class Stack{
		int data;
		Stack prev;
		Stack(int data, Stack next){
			this.data = data;
			this.prev = next;
		}
	}
	
	private Stack top;
	private Stack auxStackTop;
	
	public void push(int data){
		Stack current = new Stack(data,null);
		Stack auxStackCurrent = null;
		if(isEmpty()){
			auxStackCurrent = new Stack(data,null);
			top = current;
			auxStackTop = auxStackCurrent;
		}else{
			current.prev = top;
			top = current;
			if(data <= auxStackTop.data){
				auxStackCurrent = new Stack(data,null);
				auxStackCurrent.prev = auxStackTop;
				auxStackTop = auxStackCurrent;
			}
			
		}
	}
	
	public int pop(){
		int value = 0;
		if(isEmpty()){
			throw new EmptyStackException();
		}
		value = top.data;
		top = top.prev;
		if(value == auxStackTop.data){
			auxStackTop = auxStackTop.prev;
		}
		return value;
	}
	
	public boolean isEmpty(){
		if(top == null && auxStackTop == null){
			return true;
		}
		return false;
	}
	
	public int min(){
		if(isEmpty()){
			throw new EmptyStackException();
		}
		return auxStackTop.data;
		
	}
}
