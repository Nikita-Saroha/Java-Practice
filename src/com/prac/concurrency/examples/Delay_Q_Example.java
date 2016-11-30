package com.prac.concurrency.examples;

import java.util.Iterator;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class Delay_Q_Example{
    public static void main(String... args){
        DelayQueue<DeleyedTest>  dq=new DelayQueue();
        DeleyedTest ob1=new DeleyedTest(10);
        DeleyedTest ob2=new DeleyedTest(5);
        DeleyedTest ob3=new DeleyedTest(15);

        dq.offer(ob1);
        dq.offer(ob2);
        dq.offer(ob3);

        Iterator itr=dq.iterator();
        while(itr.hasNext()){
            DeleyedTest dt=(DeleyedTest)itr.next();
            System.out.println(dt.delayTime);
        }
    }
}
class DeleyedTest implements Delayed{
    public long delayTime=0;
    DeleyedTest(long deleyTime){
        this.delayTime=deleyTime;
    }

    @Override
    public int compareTo(Delayed ob) {
        if(this.delayTime<((DeleyedTest)ob).delayTime){
            return -1;
        }else if(this.delayTime>((DeleyedTest)ob).delayTime){
            return 1;
        }
        return 0;
    }
    @Override
    public long getDelay(TimeUnit unit) {
        unit.convert(delayTime-System.currentTimeMillis(),TimeUnit.NANOSECONDS); 
        return 0;
    }

}