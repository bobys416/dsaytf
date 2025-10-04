package dsa;

import java.util.Arrays;

/**
 * Merge sort implementation (top-down recursive).
 * <p>
 * Time complexity: O(n log n)
 * Space complexity: O(n)
 */
public class MergeSort {
	public static void sort(int[] nums) {
		if (nums == null || nums.length < 2) return;
		int[] aux = Arrays.copyOf(nums, nums.length);
		sort(nums, aux, 0, nums.length - 1);
	}

	private static void sort(int[] a, int[] aux, int left, int right) {
		if (left >= right) return;
		int mid = left + (right - left) / 2;
		sort(a, aux, left, mid);
		sort(a, aux, mid + 1, right);
		merge(a, aux, left, mid, right);
	}

	private static void merge(int[] a, int[] aux, int left, int mid, int right) {
		System.arraycopy(a, left, aux, left, right - left + 1);
		int i = left, j = mid + 1, k = left;
		while (i <= mid && j <= right) {
			if (aux[i] <= aux[j]) a[k++] = aux[i++]; else a[k++] = aux[j++];
		}
		while (i <= mid) a[k++] = aux[i++];
		while (j <= right) a[k++] = aux[j++];
	}

	public static void main(String[] args) {
		int[] data = {38, 27, 43, 3, 9, 82, 10};
		System.out.println("Before: " + Arrays.toString(data));
		sort(data);
		System.out.println("After:  " + Arrays.toString(data));
	}
}


