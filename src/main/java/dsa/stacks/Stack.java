package dsa.stacks;

public class Stack {
	
	static int[] arr=new int[10000];
	static int top=-1;
	
	public void push(int data) {
		if(top==arr.length) {
			System.out.println("Stack is full");
			return;
		}
		top++;
		arr[top]=data;
	}
	
	public int pop() {
		if(top<0) {
			System.out.println("Stack is empty");
			return -1;
		}
		return arr[top--];
	}
	
	public int top() {
		return arr[top];
	}
	
	public void printStack() {
		if(top<0) return;
		for(int i=0;i<top;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	
	public boolean isEmpty() {
		if(top<0)return true;
		return false;
	}
	
	
	public static void main(String args[]) {
		Stack stck=new Stack();
		stck.push(2);
		stck.push(3);
		stck.push(4);
		stck.push(5);
		stck.push(6);
		stck.push(7);
		stck.push(8);
		stck.push(9);
		stck.printStack();
		int data=stck.pop();
		stck.printStack();
		data=stck.top();
		stck.printStack();
		System.out.println(stck.isEmpty());
		stck.pop();
		stck.pop();
		stck.pop();
		stck.pop();
		stck.pop();
		stck.pop();
		stck.pop();
		stck.pop();
		stck.pop();
		System.out.println(stck.isEmpty());
	
	}

}
