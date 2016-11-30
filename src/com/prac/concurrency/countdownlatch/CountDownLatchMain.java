package com.prac.concurrency.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchMain {

	public static void main(String[] args) {
		CountDownLatchMain main = new CountDownLatchMain();
		CountDownLatch latch = new CountDownLatch(3);
		
		Waiter waiter = main.new Waiter(latch);
		Decrementer decrement = main.new Decrementer(latch);
		
		new Thread(waiter).start();
		new Thread(decrement).start();

	}
	
	public class Waiter implements Runnable{
		
		CountDownLatch latch = null;
		
		public Waiter(CountDownLatch latch){
			this.latch = latch;
		}

		@Override
		public void run() {
			try {
				latch.await();;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Wait over!");
		}
	}
	
	public class Decrementer implements Runnable{
		
		CountDownLatch latch = null;
		
		public Decrementer(CountDownLatch latch){
			this.latch = latch;
		}
		
		public void run(){
			try{
				Thread.sleep(5000);
				System.out.println(latch.getCount()+" - 1");
				latch.countDown();
				
				Thread.sleep(3000);
				System.out.println(latch.getCount()+" - 1");
				latch.countDown();
				
				Thread.sleep(2000);
				System.out.println(latch.getCount()+" - 1");
				latch.countDown();
				
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
}
