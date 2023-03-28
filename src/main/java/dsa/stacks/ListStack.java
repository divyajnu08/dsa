package dsa.stacks;

public class ListStack {
	
	class Node{
		int data;
		Node next;
		
		public Node(int data) {
			this.data=data;
			this.next=null;
		}
	}
	
	Node head;
	
	public void push(int data) {
		Node temp=new Node(data);
		temp.next=head;
		head=temp;
	}
	
	public int peek() {
		Node temp=head;
		return temp.data;
	}
	
	public int pop() {
		Node temp=head;
		head=head.next;
		return temp.data;
	}
	
	public boolean isEmpty() {
		if(head==null)
			return true;
		return false;
	}
	
	public void printStack() {
		Node temp=head;
		while(temp!=null) {
			System.out.print(temp.data);
			temp=temp.next;
		}
	}
	
	public static void main(String args[]) {
		ListStack stack=new ListStack();
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.printStack();
		if(stack.isEmpty()) {
			System.out.println("Stack is empty");
		}else {
			System.out.println("Stack is not empty");
		}
		int data=stack.peek();
		stack.printStack();
		System.out.println(data);
		data=stack.pop();
		stack.printStack();
		System.out.println(data);
		stack.printStack();
	}
	

}
