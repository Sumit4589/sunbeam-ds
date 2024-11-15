package sunbeam;

import java.util.Arrays;

class MaxHeap {
	private int[] arr;
	private int size;
	public MaxHeap(int[] a) {
		arr = a;
		size = arr.length - 1;
	}
	
	// O(n log n)
	public void makeHeap() {
		// heap size is number of elements in heap (1 to length)
		size = arr.length - 1;
		// from middle node to first node check if it is greater than each child node
		for(int i = size/2; i >= 1; i--) {
			// take ith element into temp variable & also take child index of ith node
			int temp = arr[i], ci = i * 2;
			// find appropriate location for temp variable.
			while(ci <= size) {
				// check if right child is available & is greater than left child
				if((ci+1) <= size && arr[ci+1] > arr[ci])
					ci = ci + 1;
				// if temp is greater than max child (ci)
				if(temp > arr[ci])
					break;
				// if child is greater than temp, promote child to its parent location
				arr[ci/2] = arr[ci];
				// check if its child is valid location for temp?
				ci = ci * 2;
			} // O(log n)
			// insert temp as parent of ci
			arr[ci / 2] = temp;
		} // O(n)
	}
	
	public int delMax() {
		// get max element from heap
		int max = arr[1];
		// take last element into temp variable & reduce size of heap
		int temp = arr[size];
		size = size - 1;
		// find appropriate location for temp variable, starting from root.
		int ci = 2; // child of root element 1 * 2.
		while(ci <= size) {
			// check if right child is available & is greater than left child
			if((ci+1) <= size && arr[ci+1] > arr[ci])
				ci = ci + 1;
			// if temp is greater than max child (ci)
			if(temp > arr[ci])
				break;
			// if child is greater than temp, promote child to its parent location
			arr[ci/2] = arr[ci];
			// check if its child is valid location for temp?
			ci = ci * 2;
		} // O(log n)
		// insert temp as parent of ci
		arr[ci / 2] = temp;
		return max;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
}

public class HeapMain {
	public static int kthHighestElement(int[] arr, int k) {
		//way1: sort the array in desc, then access kth element.
		//	sorting time = O(n log n)
		
		//way2: use maxheap = O(n log n)
		MaxHeap h = new MaxHeap(arr);
		h.makeHeap(); // O(n log n)
		int max = 0;
		for(int i=1; i<=k; i++) // O(k log n)
			max = h.delMax(); 
		return max;
	}
	
	public static void heapSort(int []arr) {
		MaxHeap h = new MaxHeap(arr);
		h.makeHeap(); // O(n log n)
		for(int i=1; i<arr.length; i++) { // O(n log n)
			int max = h.delMax();
			arr[arr.length-i] = max;
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {0, 20, 12, 35, 15, 10, 80, 30, 17, 2, 1};
		heapSort(arr);
		System.out.println(Arrays.toString(arr));
		/*
		MaxHeap h = new MaxHeap(arr);
		System.out.println(Arrays.toString(arr));
		h.makeHeap();
		System.out.println(Arrays.toString(arr));
		*/
		/*
		while(!h.isEmpty()) {
			int ele = h.delMax();
			System.out.print(ele + ", ");
		}
		System.out.println();
		*/
	}
}
