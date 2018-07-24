package finalSort;

public class insertionSort {
	
	public int[] doinsertsort(int[] ar)
    {
        int n = ar.length;       //Determining the size of the array 
        for (int i=1; i<n; i++)
        {
            int key = ar[i];    //Comparing array elements with the key
            int j = i-1;
            while (j>=0 && ar[j] > key)  //Moving elements of ar4[0..i-1], that are greater than key, to one position ahead of their current position
            {
                ar[j+1] = ar[j];
                j = j-1;
            }
            ar[j+1] = key;
        }
        return ar;
    }	
}


