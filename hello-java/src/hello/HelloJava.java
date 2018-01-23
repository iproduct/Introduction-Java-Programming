package hello;

import java.util.Date;
import java.util.Random;

public class HelloJava {
	
	public static int getRandomAge() {
		Random rand = new Random();
		int randomAge = rand.nextInt(100);
		return randomAge;
	}

	public static void main(String[] args) {
		int n = 42;
		Date now = new Date();
		String name;
		name = new String("Trayan");
		name = "Petar";
		int age = getRandomAge();
		System.out.println(now + ":");
		System.out.println("Hello " + name + " - " + age + ", from Java!");

	}

}
