package encode;

import java.util.Scanner;

public class EncodeDecode {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Input text:");
		String text = sc.nextLine();
		System.out.print("Input key:");
		int key = sc.nextInt();
		
		String encodedStr = encode(text, key);
		System.out.println("Encoded text: " + encodedStr);
		String decodedStr = decode(encodedStr, key);
		System.out.println("Decoded text: " + decodedStr);

	}
	
	private static String encode(String text, int key) {
		char[] chars = text.toCharArray();
		char[] result = new char[chars.length];
		for(int i = 0; i < chars.length; i++) {
			chars[i] += key; // increse char code by key
			result[(i + key) % result.length] = chars[i]; //rotate char to the right 'key' positions
		}
		return new String(result);
	}

	private static String decode(String encodedStr, int key) {
		char[] chars = encodedStr.toCharArray();
		char[] result = new char[chars.length];
		for(int i = 0; i < chars.length; i++) {
			chars[i] -= key; // increse char code by key
			result[(i - key + key * result.length) % result.length] = chars[i]; //rotate char to the right 'key' positions
		}
		return new String(result);
	}

}
