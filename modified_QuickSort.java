package finalSort;

public class modified_QuickSort {
	
		public int[] sort(int[] a) {
			quickSort(a, 0, a.length - 1);
			return a;
		}

		// quicksort implementation 
		  public static void quickSort(int[] array, int left, int right) {
		    int size = right - left + 1;
		    if (size <= 100) {
		      insertionSort(array);
		    } else {
		      double median = medianOf3(array, left, right);
		      int partition = partitionFunc(array, left, right, median);
		      quickSort(array, left, partition - 1);
		      quickSort(array, partition + 1, right);
		    }
		  }
		  // median of 3 logic swapping it with values
		  public static int medianOf3(int[] arr, int left, int right) {
		    int mid = (left + right) / 2;
		 
		    if (arr[left] > arr[mid])
		      swap(arr, left, mid);
		 
		    if (arr[left] > arr[right])
		      swap(arr, left, right);
		 
		    if (arr[mid] > arr[right])
		      swap(arr, mid, right);
		 
		    swap(arr, mid, right - 1);
		    return arr[right - 1];
		  }
		  // swap function
		  public static void swap(int[] arr, int i, int j) {
		    int temp = arr[i];
		    arr[i] = arr[j];
		    arr[j] = temp;
		  }
		  // Partition function for partitioning the input
		  public static int partitionFunc(int[] arr, int left, int right, double pivot) {
		    int leftPtr = left;
		    int rightPtr = right - 1;
		 
		    while (true) {
		      while (arr[++leftPtr] < pivot)
		        ;
		      while (arr[--rightPtr] > pivot)
		        ;
		      if (leftPtr >= rightPtr)
		        break;
		      else
		        swap(arr, leftPtr, rightPtr);
		    }
		    swap(arr, leftPtr, right - 1);
		    return leftPtr;
		  }
			// Insertion Sort for small length array
		  public static void insertionSort(int[] arr) {
			int n = arr.length;
			for (int i=1; i<n; ++i) {
		            	int key = arr[i];
		            	int j = i-1;
		            	while ( j >= 0 && arr[j] > key) {
		            		arr[j+1] = arr[j];
		            		j = j-1;
		            	}
		            	arr[j+1] = key;
			}	
		  }
		}