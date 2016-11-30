package com.prac.concurrency.examples;

public class CustomArrayBlockingQueue {
	
	Object[] items;
	int capacity = 10;
	int count = 0;
	
	Object lock = new Object();
	
	public CustomArrayBlockingQueue(int capacity){
		items = new Object[capacity];
		this.capacity = capacity;
	}
	
	public void put(Object o) throws InterruptedException{
		while(this.items.length == this.capacity){
			wait();
		}
		if(this.items.length == 0){
			notifyAll();
		}
		synchronized (lock) {
			this.items[count] = o;
			this.count++;
		}
	}
	
	public Object take() throws InterruptedException{
		while(this.items.length == 0){
			wait();
		}
		if(this.items.length == this.capacity){
			notifyAll();
		}
		Object o;
		synchronized (lock) {
			o = items[count-1];
			count--;
		}
		return o;
	}

}
