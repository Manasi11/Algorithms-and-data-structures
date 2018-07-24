import java.util.Random;

public class modified_quickSort {



	public int[] sort(int[] a) {
		quicksort(a, 0, a.length - 1);
		return a;
	}

	private final int CUT_OFF = 15;

	
	
	private void quicksort(int[] a, int low, int high) {
		if (low + CUT_OFF < high)
			insertionSort(a, low, high);
		else {
			
			int middle = (low + high) / 2;
			if (a[middle] < a[low])
				swapReferences(a, low, middle);
			if (a[high]< a[low])
				swapReferences(a, low, high);
			if (a[high] < a[middle])
				swapReferences(a, middle, high);

			
			swapReferences(a, middle, high - 1);
			int pivot = a[high - 1];

			
			int i, j;
			for (i = low, j = high - 1;;) {
				while (a[++i] < pivot)
					;
				while (pivot < a[--j])
					;
				if (i >= j)
					break;
				swapReferences(a, i, j);
			}

		
			swapReferences(a, i, high - 1);

			quicksort(a, low, i - 1); 
			quicksort(a, i + 1, high); 
		}
	}

	
	public void swapReferences(int[] a, int index1, int index2) {
		int tmp = a[index1];
		a[index1] = a[index2];
		a[index2] = tmp;
	}

	
	 
	private void insertionSort(int[] a, int low, int high) {

//		System.out.println("Executing insertion sort as the size of input is less than 15");

		for (int p = low + 1; p <= high; p++) {
			int tmp = a[p];
			int j;

			for (j = p; j > low && tmp < a[j - 1]; j--)
				a[j] = a[j - 1];
			a[j] = tmp;
		}
	}
}