package com.prac.concurrency.blockingqueue;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class LinkedBlocking_Deque {

	public static void main(String[] args) {
		LinkedBlocking_Deque lbd = new LinkedBlocking_Deque();
		LinkedBlockingDeque<Integer> linkedBlockingDeque = new LinkedBlockingDeque<>();
		
		Producer_Consumer pc = lbd.new Producer_Consumer(linkedBlockingDeque);
		Consumer_Producer cp = lbd.new Consumer_Producer(linkedBlockingDeque);
		
		new Thread(pc).start();
		new Thread(cp).start();
	}
	
	public class Producer_Consumer implements Runnable{
		
		BlockingDeque<Integer> blockingDeque;

		public Producer_Consumer(BlockingDeque<Integer> blockingDeque) {
			super();
			this.blockingDeque = blockingDeque;
		}

		@Override
		public void run() {
			for(int i=11; i<=20; i++)
			try {
				this.blockingDeque.putFirst(i);
				
				Thread.sleep(1000);
				
				System.out.println(Thread.currentThread().getName()+" : "+this.blockingDeque.takeLast());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	public class Consumer_Producer implements Runnable{
		
		BlockingDeque<Integer> blockingDeque;
		
		public Consumer_Producer(BlockingDeque<Integer> blockingDeque) {
			this.blockingDeque = blockingDeque;
		}
		
		@Override
		public void run() {
			for(int i=1; i<=10; i++)
			try {
				System.out.println(Thread.currentThread().getName()+" - "+this.blockingDeque.takeFirst());
				
				Thread.sleep(1000);
				
				this.blockingDeque.putLast(i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		
		
	}

}
