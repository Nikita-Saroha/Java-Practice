package com.prac.concurrency.blockingqueue;

import java.util.Iterator;
import java.util.concurrent.PriorityBlockingQueue;

public class PriorityBlocking_Queue {

	public static void main(String[] args) {
		PriorityBlocking_Queue pbq = new PriorityBlocking_Queue();
		PriorityBlockingQueue<PriorityObject> priorityBQ = new PriorityBlockingQueue<>();
		
		priorityBQ.add(pbq.new PriorityObject(1));
		priorityBQ.add(pbq.new PriorityObject(5));
		priorityBQ.add(pbq.new PriorityObject(10));
		priorityBQ.add(pbq.new PriorityObject(0));
		priorityBQ.add(pbq.new PriorityObject(4));
		priorityBQ.add(pbq.new PriorityObject(6));
		priorityBQ.add(pbq.new PriorityObject(2));
		
		
		Iterator<PriorityObject> itr = priorityBQ.iterator();
		System.out.println("Iterator ::");
		while(itr.hasNext()){
			System.out.println(itr.next().getPriority());
		}
		
		System.out.println("Taking elements out ::");
		while(!priorityBQ.isEmpty()){
			try {
				System.out.println(priorityBQ.take().getPriority());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	class PriorityObject implements Comparable<PriorityObject>{
		private int priority;
		
		public PriorityObject(int priority) {
			super();
			this.priority = priority;
		}

		public int getPriority() {
			return priority;
		}

		public void setPriority(int priority) {
			this.priority = priority;
		}

		@Override
		public int compareTo(PriorityObject o) {
			if(this.getPriority() < o.getPriority())
				return -1;
			if(this.getPriority() > o.getPriority())
				return 1;
			return 0;
		}
		
	}

}
