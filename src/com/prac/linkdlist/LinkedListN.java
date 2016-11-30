package com.prac.linkdlist;

public class LinkedListN<E> {
	
	private Node<E> last;
	public Node<E> first;
	/*public LinkedListN<E> next;
	public E value;*/
	private int size;
	
	LinkedListN(){};
	
	public void add(E value){
		Node<E> end = last;
		Node<E> current = new Node<E>(value, null);
		if(end == null){
			last = current;
			first = current;
		}else{
			end.next = current;
			last = current;
		}
		size++;
	}
	
	public void addAtFirst(E value){
		Node<E> start = first;
		Node<E> current = new Node<E>(value, null);
		if(start == null){
			last = current;
			first = current;
		}else{
			current.next = first;
			first = current;
		}
		size++;
	}
	
	public void addNodeAtEnd(Node<E> node){
		if(node == null){
			return;
		}
		Node<E> end = last;
		Node<E> current = node;
		if(end == null){
			last = current;
			first = current;
		}else{
			end.next = current;
			last = current;
		}
		size++;
	}
	
	/*LinkedListN(E value, LinkedListN<E> next){
		this.value = value;
		this.next = next;
	}
	
	public void add(E value){
		LinkedListN<E> end = last;
		LinkedListN<E> current = new LinkedListN<E>(value, null);
		if(end == null){
			last = current;
			first = current;
		}else{
			end.next = current;
			last = current;
		}
		size++;
	}*/
	
	public void empty(){
		this.first = null;
		this.last = null;
	}
	
	public int size(){
		return size;
	}
	
	public static class Node<E>{
		
		public Node<E> next;
		public E value;
		
		Node(E value, Node<E> next){
			this.value = value;
			this.next = next;
		}
	}
}
