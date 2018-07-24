
public class randomized_QuickSort {

	public int[] sort(int[] a){
		quickSort(a, 0, a.length - 1);
		
		return a;
	}

	public void quickSort(int[] a, int p, int r) {
		if (p < r) {
			int q = partition(a, p, r);
			quickSort(a, p, q);
			quickSort(a, q + 1, r);
		}
	}
	
	private void swap(int[] a, int i, int j) {

		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	private int partition(int[] a, int p, int r) {

		int x = a[p];
		int i = p - 1;
		int j = r + 1;

		while (true) {
			i++;
			while (i < r && a[i] < x)
				i++;
			j--;
			while (j > p && a[j] > x)
				j--;

			if (i < j)
				swap(a, i, j);
			else
				return j;
		}
	}

	public static void printArray(int[] arr)
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
 
        
    }
	public static int[] insertArray(int[] arr)
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            arr[i] = (int) (Math.random()*500);
 
        return arr;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		long start, end;
        
        int arr[] = new int[10000];
        insertArray(arr);
        System.out.println("Before sorting:");
        printArray(arr);
        
        start = System.currentTimeMillis();
        randomized_QuickSort ob = new randomized_QuickSort();        
        ob.sort(arr);
 end = System.currentTimeMillis();
        System.out.println(" ");
         System.out.println("After sorting:");
        printArray(arr);
        System.out.println(" ");
        System.out.println("Elapsed time: " + (end - start));
	}

}
