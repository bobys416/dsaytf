package dsa;

import java.util.Arrays;

/**
 * Selection sort implementation.
 * <p>
 * Time complexity: O(n^2)
 * Space complexity: O(1)
 */
public class SelectionSort {
	public static void sort(int[] nums) {
		if (nums == null) return;
		for (int i = 0; i < nums.length - 1; i++) {
			int minIdx = i;
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[j] < nums[minIdx]) minIdx = j;
			}
			if (minIdx != i) {
				int tmp = nums[i];
				nums[i] = nums[minIdx];
				nums[minIdx] = tmp;
			}
		}
	}

	public static void main(String[] args) {
		int[] data = {64, 25, 12, 22, 11};
		System.out.println("Before: " + Arrays.toString(data));
		sort(data);
		System.out.println("After:  " + Arrays.toString(data));
	}
}


