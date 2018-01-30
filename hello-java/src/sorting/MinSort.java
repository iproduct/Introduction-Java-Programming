package sorting;

import java.util.Arrays;
import java.util.Random;

public class MinSort {
	
	public static void sortMin(int[] a) {
		for(int i = 0; i < a.length; i++) {
			int minIndex = findMinIndex(a, i, a.length);
			swap(a, i, minIndex);
		}
	}

	public static void sortMax(int[] a) {
		for(int i = a.length; i > 0; i--) {
			int maxIndex = findMaxIndex(a, 0, i);
			swap(a, i-1, maxIndex);
		}
	}

	private static void swap(int a[], int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	private static int findMinIndex(int[] a, int start, int end) {
		int min = Integer.MAX_VALUE, minIndex = 0;
		for(int i = start; i < end; i++) {
			if(a[i] < min) {
				min = a[i];
				minIndex = i;
			}
		}
		return minIndex;
	}

	private static int findMaxIndex(int[] a, int start, int end) {
		int max = Integer.MIN_VALUE, maxIndex = 0;
		for(int i = start; i < end; i++) {
			if(a[i] > max) {
				max = a[i];
				maxIndex = i;
			}
		}
		return maxIndex;
	}

	public static void main(String[] args) {
		int[] a;
		Random rand = new Random();
		a = new int[rand.nextInt(20)];
		for (int i = 0; i < a.length; i++) {
			a[i] = rand.nextInt(100) + 1;
		}
		System.out.println(Arrays.toString(a));
		int minIndex = findMaxIndex(a, 0, a.length);
		System.out.println("Max index: " + minIndex);
		
		// sort
		sortMax(a);
		System.out.println(Arrays.toString(a));
	}

}
