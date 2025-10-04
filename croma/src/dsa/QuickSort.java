package dsa;

import java.util.Arrays;

/**
 * Quick sort implementation (Lomuto partition).
 * <p>
 * Average time: O(n log n), worst: O(n^2)
 * Space: O(log n) recursion
 */
public class QuickSort {
	public static void sort(int[] nums) {
		if (nums == null || nums.length < 2) return;
		quickSort(nums, 0, nums.length - 1);
	}

	private static void quickSort(int[] a, int low, int high) {
		if (low >= high) return;
		int p = partition(a, low, high);
		quickSort(a, low, p - 1);
		quickSort(a, p + 1, high);
	}

	private static int partition(int[] a, int low, int high) {
		int pivot = a[high];
		int i = low;
		for (int j = low; j < high; j++) {
			if (a[j] <= pivot) {
				int tmp = a[i]; a[i] = a[j]; a[j] = tmp; i++;
			}
		}
		int tmp = a[i]; a[i] = a[high]; a[high] = tmp;
		return i;
	}

	public static void main(String[] args) {
		int[] data = {10, 7, 8, 9, 1, 5};
		System.out.println("Before: " + Arrays.toString(data));
		sort(data);
		System.out.println("After:  " + Arrays.toString(data));
	}
}


