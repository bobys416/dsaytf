package dsa;

import java.util.Arrays;

/**
 * Bubble sort implementation.
 * <p>
 * Time complexity: O(n^2)
 * Space complexity: O(1)
 */
public class BubbleSort {
	public static void sort(int[] nums) {
		if (nums == null) return;
		boolean swapped;
		for (int i = 0; i < nums.length - 1; i++) {
			swapped = false;
			for (int j = 0; j < nums.length - 1 - i; j++) {
				if (nums[j] > nums[j + 1]) {
					int tmp = nums[j];
					nums[j] = nums[j + 1];
					nums[j + 1] = tmp;
					swapped = true;
				}
			}
			if (!swapped) break;
		}
	}

	public static void main(String[] args) {
		int[] data = {5, 1, 4, 2, 8};
		System.out.println("Before: " + Arrays.toString(data));
		sort(data);
		System.out.println("After:  " + Arrays.toString(data));
	}
}


