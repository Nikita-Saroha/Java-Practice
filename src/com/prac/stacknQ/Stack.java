package com.prac.stacknQ;

import java.util.EmptyStackException;

public class Stack {
	
	protected static class Node{
		Integer data;
		Node next;
		Node(Integer data, Node next){
			this.data = data;
			this.next = next;
		}
	}
	
	protected Node top;
	
	protected void push(Integer data){
		Node node = null;
		if(isEmpty()){
			node = new Node(data, null);
			top = node;
		}else{
			node = new Node(data, top);
			top = node;
		}
	}
	
	protected int pop(){
		if(isEmpty()){
			throw new EmptyStackException();
		}
		int value = top.data;
		top = top.next;
		return value;
	}
	
	protected int peek(){
		if(isEmpty()){
			throw new EmptyStackException();
		}
		int value = top.data;
		return value;
	}
	
	protected boolean isEmpty(){
		if(top == null){
			return true;
		}
		return false;
	}
}
