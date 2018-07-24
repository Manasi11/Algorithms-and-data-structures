package finalSort;

public class randomized_QuickSort {
	
	public int[] sort(int[] ar4){
		quickSort(ar4, 0, ar4.length - 1);		
		return ar4;
	}
/* In this function: ar4[] - array to be sorted 
 * low - Starting index / first element
 * high - ending index / last element */
	public void quickSort(int[] ar4, int low, int high) {
		if (low < high) {
			int p = partition(ar4, low, high);
			quickSort(ar4, low, p-1);
			quickSort(ar4, p + 1, high);
		}
	}
	
	/*Partitioning: This function takes the last element as pivot,
	 * places the pivot elements at its correct position in sorted array,
	 * and places all smaller elements than the pivot to the left of pivot 
	 * and all greater elements to the right of pivot
	 */
	private int partition(int[] ar4, int low, int high) {

		int pivot = ar4[high];
		int i = low - 1;     //Index of the smaller element
		for (int j=low; j<high; j++)
		{
            // If current element is smaller than or
            // equal to pivot
            if (ar4[j] <= pivot)
            {
                i++;
 
                // swap ar4[i] and ar4[j]
                int temp = ar4[i];
                ar4[i] = ar4[j];
                ar4[j] = temp;
            }
        }
 
        // swap ar4[i+1] and ar4[high] (or pivot)
        int temp = ar4[i+1];
        ar4[i+1] = ar4[high];
        ar4[high] = temp;
 
        return i+1;
	}
}