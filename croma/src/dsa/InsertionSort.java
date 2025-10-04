package dsa;

import java.util.Arrays;

/**
 * Insertion sort implementation.
 * <p>
 * Time complexity: O(n^2) worst, O(n) best when nearly sorted
 * Space complexity: O(1)
 */
public class InsertionSort {
	public static void sort(int[] nums) {
		if (nums == null) return;
		for (int i = 1; i < nums.length; i++) {
			int key = nums[i];
			int j = i - 1;
			while (j >= 0 && nums[j] > key) {
				nums[j + 1] = nums[j];
				j--;
			}
			nums[j + 1] = key;
		}
	}

	public static void main(String[] args) {
		int[] data = {12, 11, 13, 5, 6};
		System.out.println("Before: " + Arrays.toString(data));
		sort(data);
		System.out.println("After:  " + Arrays.toString(data));
	}
}


