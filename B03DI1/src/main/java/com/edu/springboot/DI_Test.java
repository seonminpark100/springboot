package com.edu.springboot;

class Person {
	String name;
	int age;

	/* public Person() { super(); System.out.println("public 생성자 호출"); } */

	private Person() {
		super();
		System.out.println("private 생성자 호출");
	}
}

public class DI_Test {
	/*
	 * public static void aPerson() {
	 * 
	 * Person person1 = new Person(); person1.name = "카리나"; person1.age = 26; }
	 */
	public static void aPerson(Person person2) {

		person2.name = "윈터";
		person2.age = 25;
	}
}
