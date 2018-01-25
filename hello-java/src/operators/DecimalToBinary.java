package operators;

import java.util.Scanner;

public class DecimalToBinary {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Input a number:");
		int number = sc.nextInt();
		System.out.println("Decimal: " + number);
		
		// Decimal to binary conversion
		int quotient = number;
		int	remainder;
		String binaryResult = "";
		
		while(quotient != 0) {
			remainder = quotient % 2;
			quotient /= 2;
			binaryResult = remainder + binaryResult;
		}
		System.out.println("Binary: " + binaryResult);

		// Decimal to hexadecimal conversion
		String hexadecimalResult = "";
		
		quotient = number;
		while(quotient != 0) {
			remainder = quotient % 16;
			quotient /= 16; // quotient = quotient / 16;
			char hexDigit = 
				(char)(remainder < 10 ? 
					  '0' + remainder 
					: 'A' + (remainder - 10));
			hexadecimalResult = hexDigit + hexadecimalResult;
		}
		
		System.out.println("Hex: " + hexadecimalResult);

	}

}
