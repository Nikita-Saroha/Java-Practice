package com.prac.concurrency.blockingqueue;

import java.util.concurrent.LinkedBlockingQueue;

public class LinkedBlocking_Queue {

	public static void main(String[] args) {
		LinkedBlockingQueue<Integer> linkedBlockingQueue = new LinkedBlockingQueue<Integer>(8);
		LinkedBlocking_Queue lbq = new LinkedBlocking_Queue();
		
		new Thread(lbq.new Producer(linkedBlockingQueue)).start();
		new Thread(lbq.new Consumer(linkedBlockingQueue)).start();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	class Producer implements Runnable{
		
		LinkedBlockingQueue<Integer> linkedBlockingQueue;
		
		public Producer(LinkedBlockingQueue<Integer> linkedBlockingQueue){
			this.linkedBlockingQueue = linkedBlockingQueue;
		}

		@Override
		public void run() {
			for(int i=0; i < 10; i++)
				try {
					//System.out.println(this.linkedBlockingQueue.offer(i)+" for "+i);
					this.linkedBlockingQueue.put(i);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
	}
	
	class Consumer implements Runnable{
		LinkedBlockingQueue<Integer> linkedBlockingQueue;
		public Consumer(LinkedBlockingQueue<Integer> linkedBlockingQueue){
			this.linkedBlockingQueue = linkedBlockingQueue;
		}
		public void run(){
			while(true){
				try {
					System.out.println(this.linkedBlockingQueue.take());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
