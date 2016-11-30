package com.prac;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class MymainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*List<String> list = new ArrayList<>();
		list.add("N");
		list.add("M");
		list.add("C");
		list.add("G");
		list.add("A");
		
		Collections.sort(list);
		System.out.println(list);*/
		
		/*List<Employee> empList = new ArrayList<>();
		empList.add(new Employee("M",2));
		empList.add(new Employee("M",1));
		empList.add(new Employee("M",3));
		empList.add(new Employee("M",0));
		
		Collections.sort(empList,new Employee());
		
		System.out.println(empList);*/
		
		 InetAddress inetAddress;
		try {
			inetAddress = InetAddress.getByName("127.64.84.2");
			 System.out.println ("Host Name: "+ inetAddress.getHostName());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//get the host Inet using ip
		   
		
	}

}
