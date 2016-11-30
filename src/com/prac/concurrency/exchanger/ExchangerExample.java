package com.prac.concurrency.exchanger;

import java.util.concurrent.Exchanger;

public class ExchangerExample {

	public static void main(String[] args) {
		ExchangerExample example = new ExchangerExample();
		Exchanger exchanger = new Exchanger();
		ExchangerRunnable er1 = example.new ExchangerRunnable(exchanger, "A");
		ExchangerRunnable er2 = example.new ExchangerRunnable(exchanger, "B");
		
		new Thread(er1).start();
		new Thread(er2).start();
		new Thread(example.new ExchangerRunnable(exchanger, "C")).start();
		new Thread(example.new ExchangerRunnable(exchanger, "D")).start();

	}
	
	class ExchangerRunnable implements Runnable{
		
		Exchanger exchange = null;
		Object object = null;
		
		public ExchangerRunnable(Exchanger exchange, Object obj){
			this.exchange = exchange;
			this.object = obj;
		}
		
		public void run(){
			try {
				Object prev = this.object;
				this.object = exchange.exchange(prev);
				System.out.println(Thread.currentThread().getName()+ " exchanged "+prev+" for "+this.object);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
