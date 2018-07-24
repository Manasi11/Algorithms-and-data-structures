package finalSort;
/*This program generates an array with random numbers and then the 
 * array is sorted in inverse order so that we can analyse the
 * worst case situations for different sorting techniques.  */
import java.util.Arrays;
import java.util.Random;

public class inverseSort {

	public static void printArray(int[] ar4)
    {
        int n = ar4.length;
        for (int i=0; i<n; ++i)
            System.out.print(ar4[i]+ " ");       
    }
	
	static int[] reverseArray(int arr[], int start, int end)  //Function to sort the array in inverse order
	{
			int temp;
			while (start < end)
			{
				temp = arr[start]; 
				arr[start] = arr[end];
				arr[end] = temp;
				start++;
				end--;
			}
			return arr; 
	}
	public static void main(String[] args) {
		
		insertionSort ob = new insertionSort();
		mergeSort m = new mergeSort();
		randomized_QuickSort rs = new randomized_QuickSort();
		modified_QuickSort ms = new modified_QuickSort();

		long start, finish;
		
		Random r = new Random();    
		
		int randomNextVal;
		int[]  ar4;
		ar4 = new int[20];   // The size of the array can be varied here
		
		System.out.println(" ");
		for (int i = 0; i < ar4.length; i++) {
			randomNextVal = r.nextInt(100);
			 ar4[i] = randomNextVal;
		}
		
		Arrays.sort(ar4);                      
		int[] ar5=reverseArray(ar4, 0, ar4.length-1);
		int ar6[]=ar5.clone();    //Making multiple copies of the original array
		int ar7[]=ar5.clone();
		int ar8[]=ar5.clone();
		
		System.out.println(" ");
		start = System.nanoTime();
		ar5 = rs.sort(ar5);
		finish = System.nanoTime();
		System.out.println("Time taken for quick sorting of is " + (finish - start) / 1.0 + " nanoseconds");
		//printArray(ar5);
			
		//printArray(ar6);
		start = System.nanoTime();
		ar6 = ob.doinsertsort(ar6);
			
		finish = System.nanoTime();
		System.out.println("Time taken for insertion sorting of is " + (finish - start) / 1.0 + " nanoseconds");
		//printArray(ar6);
		
		start = System.nanoTime();
		ar7 = m.sort(ar7);
		finish = System.nanoTime();
		System.out.println("Time taken for merge sorting of is " + (finish - start) / 1.0 + " nanoseconds");
		
		start = System.nanoTime();
		ar8 =ms.sort(ar8);
		finish = System.nanoTime();
		System.out.println("Time taken for modified quicksort sorting of is " + (finish - start) / 1.0 + " nanoseconds");
		
	}

}