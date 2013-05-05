package com.sirma.itt.javacourse.intro;

/**
 * Utility class finfing the center of weight of an array.
 * 
 * @author vtsonev
 */
public final class CenterOfWeightArray {

	/**
	 * private constructor preventing instantiation.
	 */
	private CenterOfWeightArray() {
	} 

	/**
	 * Returns the absolute difference between the two integers.
	 * 
	 * @param left
	 *            is the sum of the elements at the left.
	 * @param right
	 *            is the sum of the elements at the right
	 * @return the absolute difference between left and right
	 */
	private static int difference(int left, int right) {
		return Math.abs(left - right);
	}

	/**
	 * Returns the index of the element which is the center of weight of the
	 * input array.
	 * 
	 * @param array
	 *            is the input array
	 * @return The index of the center of weight of the array
	 * @throws InputSizeException
	 *             if the input array has 2 or less elements
	 */
	public static int findCenter(int[] array) throws InputSizeException {
		if (array.length <= 2) {
			throw new InputSizeException(
					"An array with 2 or less elements has no center.");
		}
		int sumLeft = 0;
		int sumRight = ArraysUtil.getSum(array);
		int minDiff = difference(sumLeft, sumRight);
		int center = -1;
		for (int i = 1; i < array.length; i++) {
			if (difference(sumLeft, sumRight) - array[i] < minDiff) {
				minDiff = difference(sumLeft, sumRight) - array[i];
				center = i;
			}
			sumLeft += array[i];
			sumRight -= array[i];
		}
		// if all array elements have the equal weight, return the middle
		if (center == -1) {
			center = array.length / 2;
		}
		return center + 1;
	}
}