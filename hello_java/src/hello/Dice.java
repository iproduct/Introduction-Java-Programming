package hello;

import java.util.Random;

public class Dice {

	public static void main(String[] args) {
		int a, b;
		Random rand = new Random();
		a = rand.nextInt(6) + 1;
		b = rand.nextInt(6) + 1;
		System.out.println("a = " + a + ", b = " + b);
		System.out.println("a + b = "  + (a + b));
		System.out.println("Equal: " + ((a == b) ? "yes" : "no"));
	}

}
