package assignment2;

import java.util.Scanner;
import java.util.Stack;

public class q3 {

	public static class MaxStack {
		
		Stack<Integer> st;
		int maxValue;
		
		MaxStack() {
			st = new Stack<>();
			maxValue = Integer.MIN_VALUE;
		}
		
		public int size() {
		    return st.size();
		}
		
		public void push(int val) {
			if (size() == 0) {
				maxValue = val;
	        	st.push(val);
	        } 
			else if (val <= maxValue) {
				st.push(val);
	        } 
			else {
	        	st.push(val + val - maxValue); 
	        	maxValue = val;
	        }
		}
	    
		public int pop() {
			if (size() == 0) {
	          System.out.println("Stack underflow");
	          return -1;
			} 
			else {
				int val = st.pop();

				if (val < maxValue) {
					return val;
				} 
				else {
					maxValue = 2 * maxValue - val;
					return 2 * maxValue - val;
				}
	        }
	    }
	    
		public int top() {
	        if (size() == 0) {
	        	System.out.println("Stack underflow");
	        	return -1;
	        } 
	        else {
	        	int val = st.peek();

	        	if (val < maxValue) {
	        		return val;
	        	} 
	        	else {
	        		return maxValue;
	        	}
	        }
		}

		int max() {
			if (size() == 0) {
	        	System.out.println("Stack underflow");
	          	return -1;
	        } 
	        else {
	        	return maxValue;
	        }
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		MaxStack ms = new MaxStack();
		for(int i=0; i<n; i++) {
			ms.push(arr[i]);
		}
		while(ms.size()>0) {
			System.out.println(ms.top() + " " + ms.max());
			ms.pop();
		}

	}
}


/*
1 3 2 5 4
[1 5 2 7 4]
 1 3 3 5 5

2*val - max
*/
