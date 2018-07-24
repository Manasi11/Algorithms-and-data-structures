
public class mergeSort {
	
    public static  int [] mergesort(int[] arr) {
    	int n= arr.length;
    	if(n<=1) {
    		return arr;
    	}
    	int middle = n/2;
    	int[] left = new int [middle];
    	int[] right;
    	
    	if(n%2 ==0 ) {
    		right = new int[middle];
    	}
    	else {
    		right = new int[middle +1];
    	}
    	int[] result = new int[n];
    	
    	for(int i=0; i<middle; i++) {
    		
    		left[i]=arr[i];
    	}
    	int a=0;
    	for (int j=middle; j< n; j++) {
    		
    		if(a< right.length)
    		{
    			right[a]=arr[j];
    			a++;
    		}
    	}
    	
    	left=mergesort(left);
    	right=mergesort(right);
    	result=merge(left,right);
    	
    	return result;
    }
    
    public static int[] merge(int [] left, int [] right) {
    	
    	int resultSize = left.length + right.length;
    	int [] result = new int [resultSize];
    	int indexleft=0;
    	int indexright=0;
    	int indexresult=0;
    	
    	while(indexleft< left.length  || indexright <right.length) {
    		
    		if(indexleft< left.length  && indexright <right.length) {
    			
    			if(left[indexleft] <= right[indexright]) {
    				result [indexresult] =left [indexleft];
    				indexleft++;
    				indexresult++;
    			}
    			
    			else {
    				
    				result [indexresult] =right [indexright];
    				indexright++;
    				indexresult++;
    			}
    		}
    		
    		else if(indexleft < left.length) {
    			
    			result [indexresult] = left [indexleft];
    			indexleft++;
    			indexresult++;
    		}
    		
    		else if(indexright < right.length) {
    			
    			result [indexresult] = right [indexright];
    			indexright++;
    			indexresult++;
    		}
    	}
    	
    	return result;
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
            arr[i] = (int) (Math.random()*5000);
 
        return arr;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		long start, end;
		        
	        int arr[] = new int[5];
	        insertArray(arr);
	 System.out.println("Before sorting:");
	 printArray(arr);
	 start = System.nanoTime();
	        arr= mergesort(arr);
	 end = System.nanoTime();
	        System.out.println(" ");
	         System.out.println("After sorting:");
	        printArray(arr);
	        System.out.println(" ");
	        System.out.println("Elapsed time: " + (end - start));
	

}
}
