package problems;

import java.util.Random;

public class Statistics {
	public static final int NUMBER_READINGS = 10;
	public static final int MAX_VALUE = 100;

	public static void main(String[] args) {
		long sum = 0;
		double average;
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		Random rand = new Random();
		
		for(int i = 0; i < NUMBER_READINGS; i++) {
//			int number = (int)(Math.random() * 100 + 1);
			int number = rand.nextInt(100) + 1;
			sum += number;
			System.out.println(number);
			//min = Math.min(min,  number);
			//if(number < min) min = number;
			min = number < min ? number: min;
			//max = Math.max(max,  number);
			//if(number > max) max = number;
			max = number > max ? number: max;

		}
		System.out.println("Sum = " + sum);
		average = (double)sum / NUMBER_READINGS;
		System.out.println("Average = " + average);
		System.out.println("Min = " + min);
		System.out.println("Max = " + max);
	}

}
