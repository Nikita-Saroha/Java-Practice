package com.prac;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class Java8Practice {

	public static void main(String[] args) {
		
		Vector<String> vec = new Vector<>();
		vec.add("AMAR");
		vec.add("SINGH");
		
		Iterator<String> itr = vec.iterator();
		
		while(itr.hasNext()){
			System.out.println(itr.next());
			vec.remove(0);
		}
		
		
	}
	
	public void runLambdaExp(){
		Integer[] intArray = { 1, 2, 3, 4, 5, 6, 7, 8 };
		List<Integer> listOfIntegers = new ArrayList<>(Arrays.asList(intArray));

		System.out.println("listOfIntegers:");
		listOfIntegers.stream().forEach(e -> System.out.print(e + " "));
		System.out.println("");

		System.out.println("listOfIntegers sorted in reverse order:");
		Comparator<Integer> normal = Integer::compare;
		Comparator<Integer> reversed = normal.reversed();
		Collections.sort(listOfIntegers, reversed);
		listOfIntegers.stream().forEach(e -> System.out.print(e + " "));
		System.out.println("");

		System.out.println("Parallel stream");
		listOfIntegers.parallelStream().forEach(e -> System.out.print(e + " "));
		System.out.println("");

		System.out.println("Another parallel stream:");
		listOfIntegers.parallelStream().forEach(e -> System.out.print(e + " "));
		System.out.println("");

		System.out.println("With forEachOrdered:");
		listOfIntegers.parallelStream().forEachOrdered(
				e -> System.out.print(e + " "));
		System.out.println("");

		System.out.println("last call");
		listOfIntegers.stream().parallel()
				.forEach(e -> System.out.print(e + " "));
		
		/*List<Employee> empList = new ArrayList<>();
		empList.add(new Employee("Nikita"));
		empList.add(new Employee("Amar"));
		empList.add(new Employee("Saroha"));
		empList.add(new Employee("Singh"));
		
		empList.forEach(emp -> emp.setName("Changed"));*/
	}

}
