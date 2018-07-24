
public class insertionSort {
	void sort(int[] arr)
    {
        int n = arr.length;
        for (int i=1; i<n; i++)
        {
            int key = arr[i];
            int j = i-1;
 
            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j>=0 && arr[j] > key)
            {
                arr[j+1] = arr[j];
                j = j-1;
            }
            arr[j+1] = key;
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
		{        
	        int arr[] = new int[500];
	        insertArray(arr);
	 System.out.println("Before sorting:");
	 printArray(arr);
	 start = System.nanoTime();
	        insertionSort ob = new insertionSort();        
	        ob.sort(arr);
	 end = System.nanoTime();
	        System.out.println(" ");
	         System.out.println("After sorting:");
	        printArray(arr);
	        System.out.println(" ");
	        System.out.println("Elapsed time: " + (end - start));
	    
	}

}
}
