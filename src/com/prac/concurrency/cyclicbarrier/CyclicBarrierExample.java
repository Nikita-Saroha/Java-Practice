package com.prac.concurrency.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {

	public static void main(String[] args) {
		CyclicBarrierExample example = new CyclicBarrierExample();
		
		Runnable action1 = new Runnable() {
			@Override
			public void run() {
				System.out.println("Action 1 executed.");
			}
		};
		
		Runnable action2 = new Runnable(){
			public void run(){
				System.out.println("Action 2 executed");
			}
		};
		
		CyclicBarrier barrier1 = new CyclicBarrier(2, action1);
		CyclicBarrier barrier2 = new CyclicBarrier(2, action2);
		
		new Thread(example.new CyclicBarrierRunnable(barrier1, barrier2)).start();
		new Thread(example.new CyclicBarrierRunnable(barrier1, barrier2)).start();

	}
	
	class CyclicBarrierRunnable implements Runnable{
		CyclicBarrier barrier1 = null;
		CyclicBarrier barrier2 = null;
		
		public CyclicBarrierRunnable(CyclicBarrier barrier1, CyclicBarrier barrier2){
			this.barrier1 = barrier1;
			this.barrier2 = barrier2;
		}
		
		public void run(){
			try {
				Thread.sleep(2000);
				System.out.println(Thread.currentThread().getName() + " is waiting on barrier 1");
				barrier1.await();
				
				Thread.sleep(2000);
				System.out.println(Thread.currentThread().getName() + " is waiting on barrier 2");
				barrier2.await();
				
				System.out.println(Thread.currentThread().getName() + " is done!");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (BrokenBarrierException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
