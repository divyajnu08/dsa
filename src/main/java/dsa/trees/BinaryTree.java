package dsa.trees;

public class BinaryTree {
	
	class Node{
		int data;
		Node left;
		Node right;
		public Node(int data) {
			this.data=data;
			this.left=this.right=null;
		}
	}
	
	public static void main(String[] args) {
		Array_imp obj=new Array_imp();
		obj.Root("A");
        obj.set_Left("B", 0);
        obj.set_Right("C", 0);
        obj.set_Left("D", 1);
        obj.set_Right("E", 1);
        obj.set_Right("F", 2);
        obj.print_Tree();
	}
	
	

}

class Array_imp{
	static int root=0;
	static String[] str=new String[10];
	
	public void Root(String key) {
		str[0]=key;
	}
	
	public void set_Left(String key,int root) {
		int t=2*root + 1;
		if(str[root]==null) {
			System.out.printf("cant set child at %d",t);
		}else {
			str[t]=key;
		}
	}
	
	public void set_Right(String key,int root) {
		int t=2*root + 2;
		if(str[root]==null) {
			System.out.printf("cant set child at %d",t);
		}else {
			str[t]=key;
		}
	}
	
	public void print_Tree() {
		for(int i=0;i<10;i++) {
			if(str[i]!=null) {
				System.out.print(str[i]);
			}else {
				System.out.print("-");
			}
		}
		
		
	}
	

	
}
