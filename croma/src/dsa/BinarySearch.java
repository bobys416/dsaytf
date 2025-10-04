package dsa;

import java.util.Arrays;

/**
 * Iterative binary search on a sorted array.
 * <p>
 * Time complexity: O(log n)
 * Space complexity: O(1)
 */
public class BinarySearch {
	/**
	 * Returns the index of the target in a sorted array or -1.
	 */
	public static int search(int[] nums, int target) {
		if (nums == null || nums.length == 0) return -1;
		int left = 0, right = nums.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] == target) return mid;
			if (nums[mid] < target) left = mid + 1; else right = mid - 1;
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] data = {1, 3, 4, 6, 8, 10};
		int target = 6;
		System.out.println("Sorted array: " + Arrays.toString(data));
		System.out.println("Target: " + target);
		int idx = search(data, target);
		System.out.println("Index found: " + idx);
	}
}


