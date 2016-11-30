package com.prac.stacknQ;

import com.prac.stacknQ.animalShelter.Cat;
import com.prac.stacknQ.animalShelter.Dog;

public class Queue<Animal> {
	
	static class Node<Animal>{
		Node<Animal> next;
		Animal data;
		
		public Node(Animal data, Node<Animal> next){
			this.data = data;
			this.next = next;
		}
	}
	
	Node<Animal> first;
	private Node<Animal> last;
	
	public void enqueue(Animal data){
		Node<Animal> current = new Node<Animal>(data, null);
		if(first == null){
			first = current;
			last = current;
		}else{
			last.next = current;
			last = current;
		}
	}
	
	public Animal dequeueAny(){
		if(first != null){
			Animal animal = first.data;
			first = first.next;
			return animal;
		}
		else
			return null;
	}
	
	public Dog dequeueDog(){
		Dog dog = null;
		if(first != null && first.data instanceof Dog){
			dog = (Dog)first.data;
			first = first.next;
		}else{
			Node<Animal> ptr = first.next;
			Node<Animal> prev = first;
			while(ptr != null){
				if(ptr.data instanceof Dog){
					dog = (Dog)ptr.data;
					prev.next = ptr.next;
					break;
				}
				prev = prev.next;
				ptr = ptr.next;
			}
		}
		return dog;
	}
	
	public Cat dequeueCat(){
		Cat cat = null;
		if(first != null && first.data instanceof Cat){
			cat = (Cat)first.data;
			first = first.next;
		}else{
			Node<Animal> ptr = first.next;
			Node<Animal> prev = first;
			while(ptr != null){
				if(ptr.data instanceof Cat){
					cat = (Cat)ptr.data;
					prev.next = ptr.next;
					break;
				}
				prev = prev.next;
				ptr = ptr.next;
			}
		}
		return cat;
	}

}
