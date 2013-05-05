package com.sirma.itt.javacourse.intro;

/**
 * Utility class having a method for sorting arrays using the quick sort
 * algorithm.
 */
public final class QuickSorter {

	/**
	 * private constructor.
	 */
	private QuickSorter() {
	}

	/**
	 * - Makes a full iteration through the array partition and places the pivot
	 * on its appropriate position.
	 * 
	 * @param arr
	 *            is the input array
	 * @param left
	 *            - the left boundary of the partition to be sorted
	 * @param right
	 *            - the right boundary of the partition to be sorted
	 * @return - the position of the appropriately placed pivot element
	 */
	private static int partition(int[] arr, int left, int right) {
		int i = left;
		int j = right;
		int tmp;
		int pivot = arr[(left + right) / 2];

		while (i <= j) {
			while (arr[i] < pivot) {
				i++;
			}
			while (arr[j] > pivot) {
				j--;
			}
			if (i <= j) {
				tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
				i++;
				j--;
			}
		}
		return i;
	}

	/**
	 * @param arr
	 *            is the array to be sorted
	 * @param left
	 *            is the left border to sort from.
	 * @param right
	 *            is the right border to sort to.
	 * @throws InputSizeException
	 *             if the length of the input array is 0
	 */
	public static void sort(int[] arr, int left, int right)
			throws InputSizeException {
		if (arr.length <= 1) {
			throw new InputSizeException();
		}
		int index = partition(arr, left, right);
		if (left < index - 1)
			sort(arr, left, index - 1);
		if (index < right)
			sort(arr, index, right);
	}
}