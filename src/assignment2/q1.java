package assignment2;

import java.util.Scanner;

public class q1 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		
		for(int i=0; i<n; i++) arr[i] = sc.nextInt();
		
		int idx = 0;
		int cnt = 1;
		for(int i=1; i<n; i++) {
			if(arr[i] == arr[i-1]) {
				cnt++;
			}
			else {
				if(cnt > 1) {
					System.out.format("Value %d is repeated %d times starting at Index %d\n", arr[idx], cnt, idx);
				}
				idx = i;
				cnt = 1;
			}
		}
		if(cnt > 1) {
			System.out.format("Value %d is repeated %d times starting at Index %d\n", arr[idx], cnt, idx);
		}
	}
}

//17
//22 9 61 61 61 21 0 9 9 9 9 35 81 81 9 5 5