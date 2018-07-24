package finalSort;

public class mergeSort {

	public static void merge(int[] array, int left, int mid, int right)

	   {
	       // Find sizes of two subarrays to be merged
	       int n1 = mid - left + 1;
	       int n2 = right - mid;
	       /* Create temp arrays */
	       int L[] = new int [n1];
	       int R[] = new int [n2];
	       //Copy data to temp arrays/
	       for (int i=0; i<n1; ++i)
	           L[i] = array[left + i];
	       
	       for (int j=0; j<n2; ++j)
	           R[j] = array[mid + 1+ j];
	       /* Merge the temp arrays */
	       // Initial indexes of first and second subarrays
	       int i = 0, j = 0;
	       // Initial index of merged subarray array
	       int k = left;
	       while (i < n1 && j < n2)
	       {
	           if (L[i] <= R[j])
	           {
	               array[k] = L[i];
	               i++;
	           }
	           else
	           {
	               array[k] = R[j];
	               j++;
	           }
	           k++;
	       }
	       /* Copy remaining elements of L[] if any */
	       while (i < n1)
	       {
	           array[k] = L[i];
	           i++;
	           k++;
	       }
	       /* Copy remaining elements of R[] if any */
	       while (j < n2)
	       {
	           array[k] = R[j];
	           j++;
	           k++;
	       }
	   }

	   // Main function that sorts ar4[l..r] using
	   // merge()
	public int[] sort(int[] ar4){
		mergeS(ar4, 0, ar4.length - 1);
		
		return ar4;
	}
	  public static void mergeS(int[] ar4, int left, int right)
	   {
	       if (left < right)
	       {
	           // Find the middle point
	           int m = (left+right)/2;
	           // Sort first and second halves
	           mergeS(ar4, left, m);
	           mergeS(ar4 , m+1, right);
	           // Merge the sorted halves
	           merge(ar4, left, m, right);
	       }
	   }
	
}

