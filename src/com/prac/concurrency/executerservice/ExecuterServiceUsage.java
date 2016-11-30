package com.prac.concurrency.executerservice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;

public class ExecuterServiceUsage {

	public static void main(String[] args) {
		ExecuterServiceUsage executerSerUsage = new ExecuterServiceUsage();
		System.out.println("Main thread !");
		executerSerUsage.useSingleThreadExecutor(executerSerUsage);
//		executerSerUsage.useFixedThreadPool(executerSerUsage);
		//executerSerUsage.useScheduledThreadPool(executerSerUsage);
		//executerSerUsage.useCachedThreadPool(executerSerUsage);
		System.out.println("Main Thread completed !");
	}
	
	/**
	 * SingleThreadExecutor creates an Executor that uses a single worker thread operating off an unbounded queue. 
	 * (Note however that if this single thread terminates due to a failure during execution prior to shutdown, 
	 * a new one will take its place if needed to execute subsequent tasks.) Tasks are guaranteed to execute sequentially, 
	 * and no more than one task will be active at any given time. 
	 * Unlike the otherwise equivalent newFixedThreadPool(1) the returned executor is guaranteed not to be reconfigurable to use additional threads.
	 * @param executerSerUsage
	 */
	public void useSingleThreadExecutor(ExecuterServiceUsage executerSerUsage ){
		ExecutorService executorService1 = Executors.newSingleThreadExecutor();
		CountDownLatch latch = new CountDownLatch(5);
		for(int i=1; i<6; i++){
			executorService1.execute(executerSerUsage.new RunnableTask(latch, i));
		}
		try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("SingleThreadExecutor shutting down");
		executorService1.shutdown();
	}
	/**
	 * FixedThreadPool creates a thread pool that reuses a fixed number of threads operating off a shared unbounded queue. 
	 * At any point, at most n threads will be active processing tasks. 
	 * If additional tasks are submitted when all threads are active, they will wait in the queue until a thread is available. 
	 * If any thread terminates due to a failure during execution prior to shutdown, a new one will take its place if needed to execute subsequent tasks. 
	 * The threads in the pool will exist until it is explicitly shutdown.
	 * @param executerSerUsage
	 */
	public void useFixedThreadPool(ExecuterServiceUsage executerSerUsage){
		ExecutorService executorService2 = Executors.newFixedThreadPool(10);
		
		List<Future<Object>> futurelist = new ArrayList<>();
		CountDownLatch latch = new CountDownLatch(5);
		for(int i=1; i<6; i++){
			Future future = executorService2.submit(executerSerUsage.new RunnableTask(latch,i));
			futurelist.add(future);
		}
		
		try {
			latch.await();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		for(Future futureObj : futurelist){
			try {
				System.out.println(futureObj.get());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		executorService2.shutdown();
	}
	
	/**
	 * Creates a thread pool that can schedule commands to run after a given delay, or to execute periodically.
	 * @param executerSerUsage
	 */
	public void useScheduledThreadPool(ExecuterServiceUsage executerSerUsage){
		ExecutorService executorScheduledThreadPool = Executors.newScheduledThreadPool(5);
		//ThreadFactory
		
		CountDownLatch latch = new CountDownLatch(5);
		List<Future<Object>> futurelist = new ArrayList<>();
//		executorScheduledThreadPool.
		for(int i=0; i<5; i++)
		{
			Future future  = executorScheduledThreadPool.submit(executerSerUsage.new CallableTask(latch, i));
			futurelist.add(future);
		}
		
		try {
			latch.await();
			System.out.println(Thread.currentThread().getName()+ " latch await over!");
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		executorScheduledThreadPool.shutdown();
		
	}
	
	public void useCachedThreadPool(ExecuterServiceUsage executerSerUsage){
		ExecutorService executorService4 = Executors.newCachedThreadPool();
	}
	
	public class RunnableTask implements Runnable{
		
		CountDownLatch latch = null;
		int i = 0;
		
		public RunnableTask(CountDownLatch latch, int i){
			this.latch = latch;
			this.i = i;
		}

		@Override
		public void run() {
			try {
				System.out.println("Putting to sleep");
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Runnable Task "+this.i+" executed.");
			
			if(this.latch != null)
				latch.countDown();
			
//			throw new RuntimeException();
		}
	}
	
	public class CallableTask  implements Callable<String>{
		
		CountDownLatch latch = null;
		int i = 0;
		
		public CallableTask(CountDownLatch latch, int i){
			this.latch = latch;
			this.i = i;
		}

		@Override
		public String call() throws Exception {
			System.out.println("Callable Task "+this.i+" executed");
			if(this.latch != null)
				latch.countDown();
			return "Executed "+this.i;
		}
		
	}

}
