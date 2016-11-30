package com.prac.concurrency.blockingqueue;

import java.util.Iterator;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class Delay_Queue {

	public static void main(String[] args) throws InterruptedException {
		DelayQueue<Employee> delayQueue = new DelayQueue<>();
		Delay_Queue dq = new Delay_Queue();
		/*delayQueue.add(dq.new Employee("Nikita",5000));
		delayQueue.add(dq.new Employee("Niki",1000));
		delayQueue.add(dq.new Employee("Nikki",2000));
		delayQueue.add(dq.new Employee("Nikku",4000));
		delayQueue.add(dq.new Employee("Saroha",3000));*/
		
		delayQueue.add(dq.new Employee("Nikita",5000));
		delayQueue.offer(dq.new Employee("Niki",1000));
		delayQueue.offer(dq.new Employee("Nikki",2000));
		delayQueue.offer(dq.new Employee("Nikku",4000));
		delayQueue.offer(dq.new Employee("Saroha",3000));
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Iterator<Employee> itr = delayQueue.iterator();
		
		while(itr.hasNext()){
			Employee emp = itr.next();
			System.out.println(emp.getName()+" - "+emp.expirationTime);
		}
		System.out.println("Taking out the values::");
		int i = 4;
		while(i >=0){
			System.out.println(delayQueue.take().getName());
			i--;
		}
		
		System.out.println(Integer.MAX_VALUE);
	}
	
	public class Employee implements Delayed{
		
		private String name;
		public long expirationTime;
		
		public Employee(String name, long delay){
			this.name = name;
			this.expirationTime = System.currentTimeMillis()+delay;
		}
		
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		@Override
		public int compareTo(Delayed o) {
			if(this.expirationTime < ((Employee)o).expirationTime ){
				return -1;
			}
			if(this.expirationTime < ((Employee)o).expirationTime ){
				return 1;
			}
			return  0;
		}

		@Override
		public long getDelay(TimeUnit unit) {
			long diff = this.expirationTime - System.currentTimeMillis();
			unit.convert(diff, TimeUnit.MILLISECONDS);
			return 0;
		}
		
	}

}
