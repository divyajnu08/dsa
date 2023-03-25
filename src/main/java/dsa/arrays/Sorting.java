package dsa.arrays;

public class Sorting {

	public static void selectionSort(int arr[]) {
		int min = 0, temp = -1;
		for (int i = 0; i < arr.length - 1; i++) {
			min = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[min]) {
					min = j;
				}
			}
			temp = arr[min];
			arr[min] = arr[i];
			arr[i] = temp;
		}
	}

	public static void bubbleSort(int[] arr) {
		boolean swapped = false;
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					swapped = true;
				}
			}
			if (swapped == false)
				break;
		}
	}

	public static void recurBubbleSort(int[] arr, int end) {
		if (end == 0)
			return;
		for (int i = 0; i < end - 1; i++) {
			if (arr[i] > arr[i + 1]) {
				int temp = arr[i];
				arr[i] = arr[i + 1];
				arr[i + 1] = temp;
			}
		}
		recurBubbleSort(arr, end - 1);
	}
	
	public static void insertionSort(int[] arr) {
		int n=arr.length;
		for(int i=1;i<n;i++) {
			int key=arr[i];
			int j=i-1;
			while( j>0 && arr[j]>key)
			{ 
				arr[j]=arr[j+1];
				j--;
			}
			arr[j+1]=key;
		}
	}
	
	public static void mergeSort(int arr[],int l,int r) {
		
		if(l<r) {
			int m=l+(r-l)/2;
			mergeSort(arr,l,m);
			mergeSort(arr,m+1,r);
			merge(arr,l,m,r);
		}
	}
	
	public static void merge(int[] arr,int l,int m,int r) {
		int n1=m-l+1;
		int n2=r-m;
		
		int L[]=new int[n1];
		int R[]=new int[n2];
		
		for(int i=0;i<n1;i++) {
			L[i]=arr[l+i];
		}
		
		for(int j=0;j<n2;j++) {
			R[j]=arr[m+j+1];
		}
		
		int i=0,j=0,k=l;
		while(i < n1 && j < n2 ) {
			if(L[i]<=R[j]) {
				arr[k++]=L[i++];
			}else{
				arr[k++]=R[j++];
			}
		}
		
		while(i<n1) {
			arr[k++]=L[i++];
		}
		
		while(j<n2) {
			arr[k++]=R[j++];
		}
		
	}
	
	public static void swap(int[] arr, int i,int j) {
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	
	public static int partition(int[] arr,int low,int high) {
		int pivot=arr[high];
		int i = low-1;
		for(int j=0;j<=high-1;j++) {
			if(arr[j]<pivot) {
				i++;
				swap(arr,i,j);
			}
		}
		swap(arr,i+1,high);
		return i+1;
		
	}
	
	public static void quickSort(int[] arr,int low,int high) {
		if(low<high) {
			int mid=partition(arr,low,high);
			quickSort(arr,low,mid-1);
			quickSort(arr,mid+1,high);
		}
	}
	
	
	
	public static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	public static void heapify(int arr[],int i,int n) {
		int l=2*i+1;
		int r=2*i+2;
		
		int largest=i;
		
		if(l<n && arr[l]>arr[largest]) {
			largest=l;
		}
		
		if(r<n && arr[r]>arr[largest]) {
			largest=r;
		}
		
		if(largest!=i) {
			int temp=arr[i];
			arr[i]=arr[largest];
			arr[largest]=temp;
			heapify(arr,largest,n);
		}
		
	}
	
	public static void heapSort(int[] arr,int n) {
		for(int i=n/2-1;i>=0;i--) {
			heapify(arr,i,n);
		}
		
		for(int i=n-1;i>=0;i--) {
			int temp=arr[0];
			arr[0]=arr[i];
			arr[i]=temp;
			heapify(arr,i,0);
		}
	}

	public static void main(String args[]) {
		int arr[] = { 64, 34, 25, 12, 22, 11, 90 };
		selectionSort(arr);
		printArray(arr);
		bubbleSort(arr);
		printArray(arr);
		recurBubbleSort(arr, arr.length);
		printArray(arr);
		insertionSort(arr);
		printArray(arr);
		mergeSort(arr,0,arr.length-1);
		printArray(arr);
		quickSort(arr,0,arr.length-1);
		printArray(arr);
		heapSort(arr,arr.length-1);
		printArray(arr);
	}

}
