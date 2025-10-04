package dsa;

import java.util.Arrays;

/**
 * Linear search implementation for arrays.
 * <p>
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class LinearSearch {
	/**
	 * Returns the first index of the target in the array or -1 if not found.
	 *
	 * @param nums   input array
	 * @param target value to search for
	 * @return index of target or -1
	 */
	public static int search(int[] nums, int target) {
		if (nums == null) return -1;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == target) return i;
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] data = {7, 2, 9, 4, 1};
		int target = 4;
		System.out.println("Array: " + Arrays.toString(data));
		System.out.println("Target: " + target);
		int idx = search(data, target);
		System.out.println("Index found: " + idx);
	}
}


