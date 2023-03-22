package dsa.arrays.searching;

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

	public static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
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
	}

}
