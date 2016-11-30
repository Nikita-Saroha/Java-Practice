package com.prac.concurrency.blockingqueue;

import java.util.concurrent.SynchronousQueue;

public class Synchronous_Queue {
	
	private int count=0;

	public static void main(String[] args) {
		SynchronousQueue<Integer> syncQueue = new SynchronousQueue<>();
		Synchronous_Queue sync = new Synchronous_Queue();
		
		//for(int i=0; i<1 ; i++)
			new Thread(sync.new Producer(syncQueue, sync)).start();
			new Thread(sync.new Consumer(syncQueue, sync)).start();

	}
	
	public void increment(){
		this.count++;
		System.out.println(this.count);
	}
	
	class Producer implements Runnable{
		SynchronousQueue<Integer> syncQueue;
		Synchronous_Queue sync;
		
		public Producer(SynchronousQueue<Integer> syncQueue,Synchronous_Queue sync) {
			super();
			this.syncQueue = syncQueue;
			this.sync = sync;
		}

		@Override
		public void run() {
			try {
				this.syncQueue.put(1);
				this.sync.increment();
				//System.out.println("hello "+Thread.currentThread().getName());
				System.out.println(this.syncQueue.take());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	class Consumer implements Runnable{
		SynchronousQueue<Integer> syncQueue;
		Synchronous_Queue sync;
		
		public Consumer(SynchronousQueue<Integer> syncQueue,Synchronous_Queue sync) {
			super();
			this.syncQueue = syncQueue;
			this.sync = sync;
		}

		@Override
		public void run() {
			try {
				this.syncQueue.take();
				this.sync.increment();
				//System.out.println("hello "+Thread.currentThread().getName());
				//System.out.println(this.syncQueue.take());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}
