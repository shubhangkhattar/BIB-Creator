package assignment2;

import java.util.Scanner;

public class q2 {
	
	public static class TwoStackCase1 {
		int[] A;
		int tos1;
		int tos2;
		int capacity;
		
		public TwoStackCase1(int capacity) {
			super();
			A = new int[capacity];
			this.tos1 = -1;
			this.tos2 = capacity;
			this.capacity = capacity;
		}

		public int sizeS1() {
			return tos1+1;
		}
		
		public int sizeS2() {
			return capacity - tos2;
		}
		
		public boolean isEmptyS1() {
			return tos1 == -1;
		}
		
		public boolean isEmptyS2() {
			return capacity == tos2;
		}
		
		public boolean isFullS1() {
			return this.sizeS1() == capacity/2;
		}
		
		public boolean isFullS2() {
			return this.sizeS2() == capacity/2;
		}
		
		
		public void pushS1(int val) {
			if(!this.isFullS1()) {
				tos1++;
				A[tos1] = val;
			}
			else {
				System.out.println("Stack Overflow");
			}
		}
		
		public void pushS2(int val) {
			if(!this.isFullS2()) {
				tos2--;
				A[tos2] = val;
			}
			else {
				System.out.println("Stack Overflow");
			}
		}
		
		public int popS1() {
			if(tos1 == -1) {
				System.out.println("Stack Underflow");
				return -1;
			}
			else {
				int val = A[tos1];
				tos1--;
				return val;
			}
		}
		
		public int popS2() {
			if(tos2 == -1) {
				System.out.println("Stack Underflow");
				return -1;
			}
			else {
				int val = A[tos2];
				tos2++;
				return val;
			}
		}
		
		public void displayS1() {
			for(int i=0; i<=this.tos1; i++) {
				System.out.print(A[i]);
			}
			System.out.println();
		}
		
		public void displayS2() {
			for(int i=this.capacity-1; i>=this.tos2; i--) {
				System.out.print(A[i]);
			}
			System.out.println();
		}
	}
	
	public static class TwoStack {
		int[] A;
		int tos1;
		int tos2;
		int capacity;
		
		public TwoStack(int capacity) {
			super();
			A = new int[capacity];
			this.tos1 = -1;
			this.tos2 = capacity;
			this.capacity = capacity;
		}

		public int sizeS1() {
			return tos1+1;
		}
		
		public int sizeS2() {
			return capacity - tos2;
		}
		
		public boolean isEmptyS1() {
			return tos1 == -1;
		}
		
		public boolean isEmptyS2() {
			return capacity == tos2;
		}
		
		public boolean isFull() {
			return this.sizeS1() + this.sizeS2() == capacity;
		}
		
		public void pushS1(int val) {
			if(!this.isFull()) {
				tos1++;
				A[tos1] = val;
			}
			else {
				System.out.println("Stack Overflow");
			}
		}
		
		public void pushS2(int val) {
			if(!this.isFull()) {
				tos2--;
				A[tos2] = val;
			}
			else {
				System.out.println("Stack Overflow");
			}
		}
		
		public int popS1() {
			if(tos1 == -1) {
				System.out.println("Stack Underflow");
				return -1;
			}
			else {
				int val = A[tos1];
				tos1--;
				return val;
			}
		}
		
		public int popS2() {
			if(tos2 == -1) {
				System.out.println("Stack Underflow");
				return -1;
			}
			else {
				int val = A[tos2];
				tos2++;
				return val;
			}
		}
		
		public void displayS1() {
			for(int i=0; i<=this.tos1; i++) {
				System.out.print(A[i]);
			}
			System.out.println();
		}
		
		public void displayS2() {
			for(int i=this.capacity-1; i>=this.tos2; i--) {
				System.out.print(A[i]);
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		int n = 5;
		TwoStack st = new TwoStack(n);
		System.out.println(st.isEmptyS1());
		System.out.println(st.isEmptyS2());
		System.out.println(st.isFull());
		
		st.pushS1(1);
		st.pushS1(2);
		st.pushS1(1);
		st.pushS1(2);
		
		st.displayS1();
		st.displayS2();
		
		
		System.out.println(st.isEmptyS1());
		System.out.println(st.isEmptyS2());
		System.out.println(st.isFull());
		
		
		st.displayS1();
		st.displayS2();
		
		st.pushS2(3);
		st.pushS2(4);
		st.pushS2(5);
		st.pushS2(5);
		
		st.displayS1();
		st.displayS2();
		System.out.println(st.isEmptyS1());
		System.out.println(st.isEmptyS2());
		System.out.println(st.isFull());

		System.out.println("========================");
		
		n = 6;
		TwoStackCase1 st1 = new TwoStackCase1(n);
		System.out.println(st1.isEmptyS1());
		System.out.println(st1.isEmptyS2());
		System.out.println(st1.isFullS1());
		System.out.println(st1.isFullS2());
		
		st1.pushS1(1);
		st1.pushS1(2);
		st1.pushS1(1);
		st1.pushS1(2);
		
		st1.displayS1();
		st1.displayS2();
		
		
		System.out.println(st1.isEmptyS1());
		System.out.println(st1.isEmptyS2());
		System.out.println(st1.isFullS1());
		System.out.println(st1.isFullS2());
		
		
		st1.displayS1();
		st1.displayS2();
		
		st1.pushS2(3);
		st1.pushS2(4);
		st1.pushS2(5);
		st1.pushS2(5);
		
		st1.displayS1();
		st1.displayS2();
		System.out.println(st1.isEmptyS1());
		System.out.println(st1.isEmptyS2());
		System.out.println(st1.isFullS1());
		System.out.println(st1.isFullS2());
	}

}
