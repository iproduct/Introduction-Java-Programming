package hello;

public class ArrayExamples {
	
	public static void printArray(int[] a) {
		System.out.print("[");
		for(int i = 0; i < a.length; i++){
			System.out.print(a[i] + ( i == a.length-1 ? "" : ", "));
		}
		System.out.println("]");
	}
	
	public static int calculateTotal(int[] a) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public static int getMinIndex(int[] a, int fromIndex) {
		int min = Integer.MAX_VALUE, minIndex = -1;
		for(int i = fromIndex; i < a.length; i++){
			if(a[i] <= min) {
				min = a[i];
				minIndex = i;
			}
		}
		return minIndex;
	}
	
	public static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void sortMinSelection(int[] a){
		for(int i = 0; i < a.length-1; i++){
			swap(a, i, getMinIndex(a, i));
		}
	}
	

	public static void main(String[] args) {
		int[] a = {23, 12, 45, 1, 3, 2, 3, 8, 56, 23, 17, 4};
		printArray(a);
		
		int  total = calculateTotal(a);
		System.out.println("Total = " + total);
		
		//Print min element
		int  minIndex = getMinIndex(a, 0);
		System.out.println("Min index: " + minIndex + " = " + a[minIndex]);
		
		//Selection sort
		sortMinSelection(a);
		printArray(a);
		
		for(int element : a){
			System.out.print(++element + ", ");
		}
		System.out.println();
		for(int element : a){
			System.out.print(element + ", ");
		}
		
	}





	
}
