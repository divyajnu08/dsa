package dsa.arrays;

public class Searching {
	
	public static void linearSearch(int[] arr,int key) {
		boolean found=false;
		for(int i=0;i<arr.length;i++) {
			if(key==arr[i]) {
				found=true;
				break;
			}
		}
		if(found==true)System.out.println("found");
		else System.out.println("Not Found");
	}
	
	public static boolean recursiveLinearSearch(int[] arr,int key,int size) {
		if(size==0)
			return false;
		if(arr[size-1]==key) {
			return true;
		}
		return recursiveLinearSearch(arr,key,size-1);
	}
	
	public static boolean sentinalLinearSearch(int[] arr,int key) {
		int last=arr[arr.length-1];
		arr[arr.length-1]=key;
		int i=0;
		while(arr[i]!=key) {
			i++;
		}
		arr[arr.length-1]=last;
		if(i<arr.length-1||last==key) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean binarySearch(int[] arr,int key) {
		int mid=0;
		int low=0,high=arr.length-1;
		while(low<=high) {
			mid=low + (high-low)/2;
			if(key==arr[mid]) {
				return true;
			}
			if(key<arr[mid]){
				high=mid-1;
			}
			if(key>arr[mid]) {
				low=mid+1;
			}
		}
		return false;
	}
	
    public static boolean recurBinarySearch(int[] arr,int key,int low,int high) {
    	if(low<=high) {
        	int mid=low+(high-low)/2;
        	if(key==arr[mid])return true;

        	if(key<arr[mid])
        		return recurBinarySearch(arr,key,low,mid-1);
        	if(key>arr[mid])
        		return recurBinarySearch(arr,key,mid+1,high);
    		
    	}
		return false;
		
    }
    
    public static void reverseArray(int[] arr) {
    	int start=0,end=arr.length-1;
    	while(start<end) {
    		int temp=arr[start];
    		arr[start]=arr[end];
    		arr[end]=temp;
    		start++;
    		end--;
    	}
    	for(int i=0;i<arr.length;i++) {
    		System.out.print(arr[i] + " ");
    	}
    }
    
    public static void leftRotate(int[] arr,int d) {
    	int[] temp=new int[arr.length];
    	int j=0;
    	for(int i=d;i<arr.length;i++) {
    		temp[j++]=arr[i];
    	}
    	for(int i=0;i<d;i++) {
    		temp[j++]=arr[i];
    	}
    	for(int i=0;i<arr.length;i++) {
    		arr[i]=temp[i];
    		System.out.print(arr[i]+" ");
    	}
    	
    }
    
    public static void rightRotate(int[] arr,int d) {
    	int[] temp=new int[arr.length];
    	int j=0;
    	for(int i=arr.length-d;i<arr.length;i++) {
    		temp[j++]=arr[i];
    	}
    	for(int i=0;i<arr.length-d;i++) {
    		temp[j++]=arr[i];
    	}
    	for(int i=0;i<arr.length;i++) {
    		arr[i]=temp[i];
    		System.out.print(arr[i]+" ");
    	}
    }
    
    public static int searchUnsorted(int[] arr,int key) {
    	for(int i=0;i<arr.length;i++) {
    		if(arr[i]==key) {
    			return i;
    		}
    	}
    	return -1;
    }
    
    public static void insertUnsorted(int[] arr,int key,int pos,int capacity) {
    	if(pos>capacity) {
    		System.out.println("Capacity less than index");
    	}else {
    		for(int i=capacity-1;i>=pos;i--) {
    			arr[i]=arr[i-1];
    		}
    		arr[pos]=key;
    	}
    }
    
    public static void deleteUnsorted(int[] arr,int key) {
    	int pos=searchUnsorted(arr,key);
    	for(int i=pos+1;i<arr.length;i++) {
    		arr[i-1]=arr[i];
    	}
    	arr[arr.length-1]=-1;
    }
    
    public static void printArray(int[] arr) {
    	for(int i=0;i<arr.length;i++) {
    		System.out.print(arr[i]+" ");
    	}
    }
	
	
	public static void main(String args[]) {
		int arr[] = {10, 20, 180, 30, 60, 50, 110, 100, 70};
		linearSearch(arr,180);
		System.out.println(recursiveLinearSearch(arr,180,9));
		System.out.println(sentinalLinearSearch(arr,180));
		int arr2[] = {10,20,30,50,60,70,100,110,180};
		System.out.println(binarySearch(arr2,180));
		System.out.println(recurBinarySearch(arr2,180,0,arr.length-1));
		reverseArray(arr);
		System.out.println();
		reverseArray(arr);
		System.out.println();
		leftRotate(arr,2);
		System.out.println();
		rightRotate(arr,2);
		System.out.println();
		int arr3[]=new int[5];
		arr3[0]=2;
		arr3[1]=4;
		arr3[2]=6;
		arr3[3]=8;
		insertUnsorted(arr3,80,2,5);
		printArray(arr3);
		deleteUnsorted(arr3,4);
		System.out.println();
		printArray(arr3);
	}

}
