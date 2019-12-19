import java.util.Arrays;
import java.util.Scanner;


public class BubbleSort {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter how many numbers to sort:");
		int n=sc.nextInt();
		
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		
		//flag to break from loop to remove replication of passes if everything gets sorted before n-1 passes
		boolean flag;
		
		//we need atmost n-1 passes to sort n elements: In each pass, atleast one element is bubbled up to 
		for(int i=0;i<n;i++) {
			//Initially at every pass, flag is false
			flag=false;
			
			//we need n-1 for swapping check and n-i-1 because at every pass, atleast one maximum element is bubbled
			for(int j=0;j<n-i-1;j++) {
				if(arr[j]>arr[j+1]) {
					
					//simple swap
					int temp=arr[j+1];
					arr[j+1]=arr[j];
					arr[j]=temp;
					//mark flag as true so that we are sure of still using the pass for bubbling the max element
					flag=true;
				}
			}
			
			//if flag is not used that means, no more pass is needed , and array is sorted alredy
			if(!flag) break;
		}
		
		System.out.println(Arrays.toString(arr));
		sc.close();
	}
}
