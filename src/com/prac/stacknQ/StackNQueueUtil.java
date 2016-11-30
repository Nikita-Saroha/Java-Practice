package com.prac.stacknQ;

public class StackNQueueUtil {
	
	public static void sort(Stack s){
		int temp = 0;
		if(!s.isEmpty()){
			temp = s.pop();
			sort(s);
		}
		if(temp != 0)
		insertSortedStackBack(temp, s);
	}
	
	public static void insertSortedStackBack(int data, Stack s){
		if(s.isEmpty() || data > s.top.data){
			s.push(data);
		}else{
			int temp = s.pop();
			insertSortedStackBack(data, s);
			s.push(temp);
		}
	}

}
