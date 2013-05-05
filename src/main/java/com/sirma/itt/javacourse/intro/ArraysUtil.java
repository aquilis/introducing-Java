package com.sirma.itt.javacourse.intro;

/**
 * A utility class with static methods for manipulating arrays.
 */
public final class ArraysUtil {
	/**
	 * Private constructor preventing instantiation.
	 */
	private ArraysUtil() {
	}

	/**
	 * Gets the smallest elemet of a given array.
	 *
	 * @param array
	 *            is the input array of integers
	 * @return the smallest elemet from the array
	 */
	public static int getMinElement(int[] array) {
		int min = array[0];
		for (int i = 1; i < array.length; i++) {
			if (array[i] < min) {
				min = array[i];
			}
		}
		return min;
	}

	/**
	 * Gets the sum of all elements in an array.
	 *
	 * @param array
	 *            is the input array of integers
	 * @return the sum of all elements
	 */
	public static int getSum(int[] array) {
		int sum = 0;
		for (int i : array) {
			sum += i;
		}
		return sum;
	}

	/**
	 * Prints the array on the console.
	 *
	 * @param array
	 *            is the array to be printed
	 */
	public static void print(int[] array) {
		System.out.print("[");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
			if (i < array.length - 1) {
				System.out.print(", ");
			}
		}
		System.out.print("]");
	}
}
