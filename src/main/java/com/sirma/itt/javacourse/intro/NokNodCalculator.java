package com.sirma.itt.javacourse.intro;

/**
 * utility class with methods for finding the greatest common divisor and least
 * common multiple of two numbers.
 */
public final class NokNodCalculator {

	/**
	 * a private constructor preventing instantiation.
	 */
	private NokNodCalculator() {
	}

	/**
	 * Finds the greatest common divisor of the two numbers.
	 * 
	 * @param num1
	 *            is the first input number
	 * @param num2
	 *            is the second input number
	 * @return - the greatest common divisor of a and b
	 */
	public static int findNod(int num1, int num2) {
		if ((num1 == 0) || (num2 == 0)) {
			throw new IllegalArgumentException();
		}
		int a = num1;
		int b = num2;
		while (a != b) {
			if (a > b) {
				a = a - b;
			} else {
				b = b - a;
			}
		}
		return a;
	}

	/**
	 * Finds the least common multiple of the two numbers.
	 * 
	 * @param a
	 *            is the first input integer
	 * @param b
	 *            is the second input integer
	 * @return the last common multiple of a and b
	 */
	public static int findNok(int a, int b) {
		return (a * b) / findNod(a, b);
	}
}