package com.sirma.itt.javacourse.intro;

/**
 * Utility class having method for reversing a given array or string backwards.
 */
public final class ArrayReverser {
	/**
	 * private constructor.
	 */
	private ArrayReverser() {
	}

	/**
	 * Reverses an array using the partition method.
	 * 
	 * @param arr
	 *            - the array to be reversed
	 */
	public static void reverseArray(int[] arr) {
		for (int i = 0; i < arr.length / 2; i++) {
			int temp = arr[i];
			arr[i] = arr[arr.length - 1 - i];
			arr[arr.length - 1 - i] = temp;
		}
	}

	/**
	 * reverses a string backwards.
	 * 
	 * @param input
	 *            - the string to be reversed
	 * @return the reversed input string
	 */
	public static String reverseString(String input) {
		String reversed = "";
		for (int i = input.length() - 1; i >= 0; i--) {
			reversed += input.charAt(i);
		}
		return reversed;
	}
}