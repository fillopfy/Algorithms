import java.lang.*;
import java.util.*;
import java.io.*;


public class SelectionSort {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter how many numbers to Sort: ");
		
		//taking n numbers from user
		int n=sc.nextInt();
		int[] arr=new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		
		//pointer to mark two arrays in the array, one with sorted and other with unsorted elements
		int start=0;
		while(start<n) {
			
			//taking min as Infinity and its index in array is -1
			int min=Integer.MAX_VALUE;
			int index=-1;
			
			//searching for minimum element(to sort in ascending order): O(n)
			for(int i=start;i<n;i++) {
				if(arr[i]<min) {
					min=arr[i];
					index=i;
				}
			}
			
			//swapping the minimum found to sorted list and increasing its size as well
			int temp=arr[start];
			arr[start]=min;
			arr[index]=temp;
			++start;
		}
		
		System.out.println(Arrays.toString(arr));
		sc.close();
	}

}
