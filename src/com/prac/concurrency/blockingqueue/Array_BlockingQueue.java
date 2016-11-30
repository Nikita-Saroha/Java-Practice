package com.prac.concurrency.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;;

public class Array_BlockingQueue {
	
	
	public static void main(String args[]) throws InterruptedException{
		Array_BlockingQueue abq = new Array_BlockingQueue();
		ArrayBlockingQueue<Integer> blockingQ = new ArrayBlockingQueue<Integer>(3);
		Array_BlockingQueue.Producer producer =  abq.new Producer(blockingQ);
		Array_BlockingQueue.Consumer consumer =  abq.new Consumer(blockingQ);
		
		new Thread(producer).start();
		//new Thread(consumer).start();
		
		Thread.sleep(6000);
		
	}
	
	class Producer implements Runnable{
		
		ArrayBlockingQueue<Integer> arrayBlockingQueue;
		
		public Producer(ArrayBlockingQueue<Integer> arrayBlockingQueue){
			this.arrayBlockingQueue = arrayBlockingQueue;
		}
		
		@Override
		public void run() {
			try {
				arrayBlockingQueue.put(1);
				System.out.println("added 1");
				Thread.sleep(2000);
				arrayBlockingQueue.put(2);
				System.out.println("added 2");
				Thread.sleep(2000);
				arrayBlockingQueue.put(3);
				System.out.println("added 3");
				Thread.sleep(2000);
				arrayBlockingQueue.put(4); // Will wait , if no element is dequeued from a full queue
				System.out.println("added 4");
				arrayBlockingQueue.add(5); // causes queue full exception if called after 3 elements are inserted and none are dequeued
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	class Consumer implements Runnable{
		
		ArrayBlockingQueue<Integer> arrayBlockingQueue;
		
		public Consumer(ArrayBlockingQueue<Integer> arrayBlockingQueue){
			this.arrayBlockingQueue = arrayBlockingQueue;
		}

		@Override
		public void run() {
			try {
				System.out.println(arrayBlockingQueue.take());
				System.out.println(arrayBlockingQueue.take());
				System.out.println(arrayBlockingQueue.take());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

}
