package com.prac.concurrency;

import java.util.concurrent.atomic.AtomicInteger;

public class ResourceUtilizationMonitor implements Runnable{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t1 = null;
		for(int i=0; i <= 10; i++){
			t1 = new Thread(new ResourceUtilizationMonitor(),"Thread "+i);
			t1.start();
			//System.out.println("inside loop");
			//t1.run();
		}
		
		System.out.println("Main");
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			System.out.println(Thread.currentThread().getName());
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
