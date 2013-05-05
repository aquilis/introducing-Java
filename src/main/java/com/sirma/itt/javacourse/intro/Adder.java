package com.sirma.itt.javacourse.intro;

/**
 * Utility class that has a static method for adding two numbers using the
 * digit-by-digit way.
 */
public final class Adder {

	/**
	 * private constructor preventing instantiation.
	 */
	private Adder() {
	}

	/**
	 * Returns the first digit of the given two-digits number.
	 * 
	 * @param a
	 *            is the input number
	 * @return the first digit of the input integer
	 */
	private static int extractFirstDigit(int a) {
		return a / 10;
	}

	/**
	 * Returns the secnod digit of the given two-digits number.
	 * 
	 * @param a
	 *            is the input integer number
	 * @return the second digit of the input integer
	 */
	private static int extractSecondDigit(int a) {
		double input = a;
		double temp = ((input / 10) - extractFirstDigit((int) input)) * 10;
		return (int) temp;
	}

	/**
	 * Returns true if the given number is two-digit
	 * 
	 * @param a
	 *            is the input integer number
	 * @return true if the integer has more than one digit
	 */
	private static boolean hasTwoDigits(int a) {
		int temp = a / 10;
		if (temp == 0) {
			return false;
		}
		return true;
	}

	/**
	 * Adds the two numbers suing the digit-splitting approach.
	 * The input numbers have to be represented as strings.
	 * 
	 * @param a
	 *            is the first number to add
	 * @param b
	 *            is the second number to add
	 * @return the total of and b
	 * @throws InputSizeException
	 *             if the length of one of the input strings is 0
	 */
	public static String add(String a, String b) throws InputSizeException {
		if ((a.length() == 0) || (b.length() == 0)) {
			throw new InputSizeException();
		}
		String bigger;
		String smaller;
		// determine which is the bigger and smaller number
		if (a.length() == b.length()) {
			bigger = a;
			smaller = b;
		} else {
			bigger = a.length() > b.length() ? a : b;
			smaller = a.length() < b.length() ? a : b;
		}
		String result = "";
		int temp = 0;
		int remainder = 0;
		int offset = bigger.length() - smaller.length();
		for (int i = bigger.length() - 1; i >= 0; i--) {
			if ((i + 1) > offset) {
				temp = Character.getNumericValue(bigger.charAt(i))
						+ Character.getNumericValue(smaller.charAt(i - offset))
						+ remainder;
				if (!hasTwoDigits(temp)) {
					result += Integer.toString(temp);
					remainder = 0;
				} else {
					result += Integer.toString(extractSecondDigit(temp));
					remainder = extractFirstDigit(temp);
				}
			} else {
				temp = Character.getNumericValue(bigger.charAt(i)) + remainder;
				if (!hasTwoDigits(temp)) {
					result += Integer.toString(temp);
					remainder = 0;
				} else {
					result += Integer.toString(extractSecondDigit(temp));
					remainder = extractFirstDigit(temp);
				}
			}
		}
		if (remainder > 0) {
			result += remainder;
		}
		return ArrayReverser.reverseString(result);
	}
}