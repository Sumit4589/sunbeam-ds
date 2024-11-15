package sunbeam;

import java.util.Scanner;

class SimpleStack {
	private int[] arr;
	private int top;
	
	public SimpleStack(int size) {
		arr = new int[size];
		top = -1;
	}
	public void push(int val) {
		if(isFull())
			throw new RuntimeException("Stack is Full");
		top++;
		arr[top] = val;
	}
	public void pop() {
		if(isEmpty())
			throw new RuntimeException("Stack is Empty");
		top--;
	}
	public int peek() {
		if(isEmpty())
			throw new RuntimeException("Stack is Empty");
		return arr[top];
	}
	public boolean isEmpty() {
		return top == -1;
	}
	public boolean isFull() {
		return top == arr.length-1;
	}
}

public class StackMain {
	public static void main(String[] args) {
		SimpleStack s = new SimpleStack(6);
		Scanner sc = new Scanner(System.in);
		int choice, val;
		do {
			System.out.print("\n1. Push\n2. Pop\n3. Peek\nEnter choice: ");
			choice = sc.nextInt();
			switch (choice) {
			case 1: // push
				try {
					System.out.print("Enter value to push: ");
					val = sc.nextInt();
					s.push(val);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 2: // pop
				try {
					System.out.println("Value popped: " + s.peek());
					s.pop();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 3: // peek
				try {
					val = s.peek();
					System.out.println("Value peeked: " + val);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			}
		}while(choice != 0);
		sc.close();		
	}
}
