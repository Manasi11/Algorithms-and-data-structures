package finalSort;

public class sortCall {
	
	/* A function to print array of size n */ 
	public static void printArray(int[] arr)
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+ " ");        
    }
	/* A function to generate an array with random elements*/
	public static int[] insertArray(int[] arr)
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            arr[i] = (int) (Math.random()*500);
        return arr;
    }
	
	/* Main function where different types of sorts are called and time taken for each
	 * sorting technique is calculated */
	public static void main(String[] args) {
		
		insertionSort ob = new insertionSort();
		mergeSort m = new mergeSort();  
		randomized_QuickSort rs = new randomized_QuickSort();
		modified_QuickSort ms = new modified_QuickSort();  
			
		long start, end;
		{      
				int a=500;    // The input size is varied here 
	        	int arr[] = new int[a];
	        	insertArray(arr);
	        	int arr2[]=arr.clone();
	        	int arr3[]=arr.clone();
	        	int arr4[]=arr.clone();
	        	int arr5[]=arr.clone();
	        	
	        	System.out.println("**********Insertion Sorting:************");
	            //printArray(arr2);
	 	        start = System.nanoTime();        
	        	ob.doinsertsort(arr2);
	        	end = System.nanoTime();
	        	System.out.println(" ");
	         	//System.out.println("After sorting Insertion Sorting:");
	        	//printArray(arr2);
	        	System.out.println(" ");
	        	System.out.println("Elapsed time: " + (end - start) + " nanoseconds");
	        
	        	System.out.println("***********Merge Sorting:**************");
	   	 		//printArray(arr3);
	   	 	   	start = System.nanoTime();    
	   	        m.sort(arr3);
	   	        end = System.nanoTime();
	   	        //System.out.println(" ");
	   	        //System.out.println("After sorting Merge Sorting:");
	   	        //printArray(arr3);
	   	        System.out.println(" ");
	   	        System.out.println("Elapsed time: " + (end - start) + " nanoseconds");
	   	        
	   	        System.out.println("************Randomized Quicksort:***********");
	   	        //printArray(arr4);
		   	 	start = System.nanoTime();      
	   	        rs.sort(arr4);
	   	        end = System.nanoTime();
		   	    System.out.println(" ");
		   	    // System.out.println("After sorting Randomized Quicksort:");
		   	    // printArray(arr4);
		   	    System.out.println(" ");
		   	    System.out.println("Elapsed time: " + (end - start) + " nanoseconds");
		   	        
		   	     System.out.println("************Modified Quicksort:**************");
			     start = System.nanoTime();     
		         ms.sort(arr5);
			   	 end = System.nanoTime();
			   	 System.out.println(" ");
			   	 System.out.println("After sorting Modified Quicksort:");
			   	 System.out.println("Elapsed time: " + (end - start) + " nanoseconds");     
	    }	
	}
}
