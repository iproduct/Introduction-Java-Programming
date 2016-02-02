package hello;

import java.util.Date;

public class HelloDate {

	public static void main(String[] args) {
		Date now = new Date();
		String name = new String("Trayan");
		System.out.println(now.toString() + ": Hello, " 
				+ name + " from Java 8!");

	}

}
