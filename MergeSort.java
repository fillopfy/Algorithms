import java.io.*;
import java.util.*;

public class MergeSort {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("How many numbers? ");
		int n=sc.nextInt();
		int[] arr=new int[n];
		System.out.println("Enter the numbers: ");
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		
		//passing the array into merge sort function
		Sort(arr);
		System.out.println(Arrays.toString(arr));
		
	}
	
	public static void Sort(int[] arr) {
		int n=arr.length;
		
		//if single element, no more divide
		if(n<2) {
			return;
		}
		
		int mid=n/2;
		//dividing the array into two halves
		int[] left=new int[mid];
		int[] right=new int[n-mid];
		
		//copying array elements into their respective halves
		for(int i=0;i<mid;i++) {
			left[i]=arr[i];
		}
		
		for(int i=mid;i<n;i++) {
			right[i-mid]=arr[i];
		}
		
		//calling sort individually in left and right subarrays so that dividing of elements reaches to the point when only one element is left
		Sort(left);
		Sort(right);
		//after dividing is done, we are gonna merge them by comparing 
		Merge(left,right,arr);
		
		
		
	}
	
	public static void  Merge(int[] left, int[] right, int[] res) {
		int n=left.length;
		int m=right.length;
		
		//we need three pointers: one for left array, one for right array and last for updating elements in final array
		int i=0,j=0,k=0;
		
		//i and j both must statisfy the condition that they both should be less then their total
		while(i<n && j<m) {
			if(left[i]<right[j]) {
				res[k]=left[i];
				i++;
			}else {
				res[k]=right[j];
				j++;
			}
			
			k++;
		}
		
		//if left array has still some elements left
		while(i<n) {
			res[k++]=left[i++];
		}
		
		//if right array has still some elements left
		while(j<m) {
			res[k++]=right[j++];
		}
		
	}
}
