package finalSort;
/*This program generates an array with random numbers and then the 
 * array is sorted in ascending order so that we can analyse the
 * best case situations for different sorting techniques.  */
import java.util.Random;
import java.util.Arrays;
public class sorted_Array {
	
	public static void printArray(int[] arr)
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+ " ");       
    }

	public static void main(String[] args) {

		insertionSort ob = new insertionSort();
		mergeSort m = new mergeSort();
		randomized_QuickSort rs = new randomized_QuickSort();
		modified_QuickSort ms = new modified_QuickSort();

		long start, finish;
		
		Random r = new Random();        
		int randomNextVal;
		int[] ar4, ar5, ar6, ar7;
		ar4 = ar5 = ar6 = ar7 = new int[500];
		
	System.out.println(" ");
		for (int i = 0; i < ar4.length; i++) {        //to generate random numbers in an array
			randomNextVal = r.nextInt(100);
			 ar4[i] = randomNextVal;
		}
		
			Arrays.sort(ar4);                       // sorting the randomly generated array in ascending order/already sorted order
			Arrays.sort(ar5);
			Arrays.sort(ar6);
			Arrays.sort(ar7);
			//printArray(ar4);
			System.out.println(" ");
			start = System.nanoTime();
			ar4 = rs.sort(ar4);
			finish = System.nanoTime();
			System.out.println("Time taken for quick sorting of is " + (finish - start) / 1.0 + " nanoseconds");
			//printArray(ar4);
			
			start = System.nanoTime();
			ar4 = ob.doinsertsort(ar5);
		    finish = System.nanoTime();
			System.out.println("Time taken for insertion sorting of is " + (finish - start) / 1.0 + " nanoseconds");
			//printArray(ar5);
		
			start = System.nanoTime();
			ar4 = m.sort(ar6);
			finish = System.nanoTime();
			System.out.println("Time taken for merge sorting of is " + (finish - start) / 1.0 + " nanoseconds");
		
			start = System.nanoTime();
			ar4 =ms.sort(ar7);
			finish = System.nanoTime();
			System.out.println("Time taken for modified quicksort sorting of is " + (finish - start) / 1.0 + " nanoseconds");
				
		}
}