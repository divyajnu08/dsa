package dsa.inkedlists;
	
class LinkedList{
		
		Node head;
		
		class Node{
			int data;
			Node next;
			public Node(int data) {
				this.data=data;
				this.next=null;
			}
		}
		
		public void push(int data) {
			Node temp=new Node(data);
			temp.next=head;
			head = temp;
		}
		
		public void insertAfter(Node previous,int data) {
			if(previous==null) {
				System.out.println(
			            "The given previous node cannot be null");
			        return;
			}
			
			Node temp = new Node(data);
			temp.next=previous.next;
			previous.next=temp;
		}
		
		public void append(int data) {
			Node temp=new Node(data);
			Node p=head;
			if(head==null) {
				head=temp;
				return;
			}
			while(p.next!=null) {
				p=p.next;
			}
			p.next=temp;
		}
		
		public boolean search(int data) {
			Node p=head;
			while(p!=null) {
				if(p.data==data)return true;
				p=p.next;
			}
			return false;
		}
		
		public boolean recurSearch(Node head,int data) {
			if(head==null) {
				return false;
			}
			if(head.data==data) {
				return true;
			}
			return recurSearch(head.next,data);
		}
		
		public void printList() {
			Node temp=head;
			while(temp!=null) {
				System.out.print(temp.data+" ");
				temp=temp.next;
			}
			System.out.println();
		}
		
		public int length() {
			int count=0;
			Node temp=head;
			while(temp!=null) {
				temp=temp.next;
				count++;
			}
			return count;
		}
		
		public int recurLength(Node head) {
			if(head==null)return 0;
			return 1 + recurLength(head.next);
		}
		
		public void reverse() {
			Node prev=null;
			Node next=null;
			Node curr=head;
			
			while(curr!=null) {
				next=curr.next;
				curr.next=prev;
				prev=curr;
				curr=next;
			}
			head=prev;
		}
		
		public Node recurReverse(Node head) {
			if(head==null || head.next==null) {
				return head;
			}
			Node rest=recurReverse(head.next);
			head.next.next=head;
			head.next=null;
			return rest;
		}
		
		public void deleteStart() {
			if(head==null) {
				return;
			}
			Node temp=head;
			head=head.next;
			temp.next=null;
		}
		
		public void deleteEnd() {
			Node temp=head;
			Node prev=null;
			while(temp.next!=null) {
				prev=temp;
				temp=temp.next;
			}
			prev.next=null;
		}
		
		public void deleteN(Node head,int pos) {
			int count=0;
			Node prev=null;
			Node curr=head;
			while(count<pos) {
				prev=curr;
				curr=curr.next;
				count++;
			}
			prev.next=curr.next;
			curr.next=null;
		}
		
		public void delete(int key) {
			Node prev=null;
			Node curr=head;
			
			if (curr != null && curr.data == key) {
	            head = curr.next; // Changed head
	            return;
	        }
			while(curr!=null && curr.data!=key) {
				prev=curr;
				curr=curr.next;
			}
			if(curr==null)
				return;
			
			prev.next=curr.next;
			
			
		}
		
		public void deleteList() {
			Node p=head;
			head=head.next;
			head=null;
		}
		
		public int getNth(int N) {
			Node p=head;
			while(N-->0) {
				p=p.next;
			}
			return p.data;
		}
		
		public int getNthFromEnd(int N) {
		  Node p=head,q=p;
		  while(N-1>0) {
			  p=p.next;
			  N--;
		  }	
		  while(p.next!=null) {
			  q=q.next;
			  p=p.next;
		  }
		  return q.data;
		}
	}
	
	public class SinglyLinkedList {	
		
	public static void main(String[] args) {
		LinkedList llist = new LinkedList();
		llist.append(6);
		llist.push(7);
		llist.push(1);
		llist.append(4);
		llist.insertAfter(llist.head.next, 8);
		System.out.println("\nCreated Linked list is: ");
        llist.printList();
        if (llist.recurSearch(llist.head, 21))
            System.out.println("Yes");
        else
            System.out.println("No");
        System.out.println("Number of nodes"+llist.length());
        System.out.println("Number of nodes"+llist.recurLength(llist.head));
        llist.reverse();
        llist.printList();
        llist.head=llist.recurReverse(llist.head);
        llist.printList();
        llist.reverse();
        llist.printList();
        llist.deleteStart();
        llist.printList();
        llist.deleteN(llist.head, 2);
        llist.printList();
        llist.delete(8);
        llist.printList();
        llist.deleteList();
        llist.printList();
        llist.append(6);
		llist.push(7);
		llist.push(1);
		llist.append(4);
		llist.printList();
		System.out.println(llist.getNth(1));
		System.out.println(llist.getNthFromEnd(2));
	}

}
