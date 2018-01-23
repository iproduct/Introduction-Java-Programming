package users;

import java.util.Scanner;

public class Person extends Object {
	private String name = "Anonimous";
	private int age;
	
	// No arg constructor
	public Person() {
		age = 25;
	}
	
	// Full constructor
	public Person(String aName, int anAge) {
		name = aName;
		age = anAge;
	}
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int newAge) {
		age = newAge;
	}

	public void setName(String newName) {
		name = newName;
	}
	
	@Override
	public String toString() {
		return "Name: " + name + ", Age: " + age;
	}
	
	public void inputPersonData() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Your name: ");
		setName(sc.nextLine());
		System.out.print("Your age: ");
		String ageStr = sc.nextLine();
		try {
			setAge(Integer.parseInt(ageStr));
		} catch (NumberFormatException ex) {
			System.out.println("Invalid number. Try again.");
		}
	}

	public static void main(String[] args) {
		Person p1 = new Person("Ivan Petrov", 35);
		Person p2 = new Person("John Smith", 45);
		Person p3 = new Person();
		p3.inputPersonData();
	
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);

	}

}
