package hello;

import java.util.Date;

public class HelloDate {

	public static void main(String[] args) {
		Date now = new Date();
		String name = new String("Trayan");
		System.out.println(now.toString() + ": Hello, " 
				+ name + " from Java 8!");
		
		int x = 0, y = 1, z = 2;
		String sString = "x, y, z ";
		System.out.println(sString + (x + y + z));

	}

}
