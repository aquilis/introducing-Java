package com.sirma.itt.javacourse.intro;

import java.util.Random;

/**
 * Utility class having a method for generating a random string with a given
 * size and given parameters indexing what types of characters are expected as
 * an output from the method.
 *
 * @version 1.2
 */
public final class StringGenerator {

	/**
	 * a private constructor.
	 */
	private StringGenerator() {
	}

	/**
	 * Returns a random ASCII character choosing it randomly from the parameters
	 * in the input string - allowedChars.
	 * 
	 * @param allowedChars
	 *            is a string that can consist of l,L,d,c (where l is lowercase
	 *            letter, L is uppercase letter d is a digit and c is a special
	 *            character) and tells the method what ASCII chars it's allowed
	 *            to generate. The string parameters are speerated by commas.
	 * @return a random character consisting of chars from the gien interval
	 */
	private static char nextChar(String allowedChars) {
		Random rnd = new Random();
		int result = -1;
		String[] allowed = allowedChars.split("[,]+");
		String temp = allowed[rnd.nextInt(allowed.length)];
		if ("l".equals(temp)) {
			result = rnd.nextInt(25) + 97;
		} else if ("L".equals(temp)) {
			result = rnd.nextInt(25) + 65;
		} else if ("d".equals(temp)) {
			result = rnd.nextInt(9) + 48;
		} else if ("c".equals(temp)) {
			// choose randomly to generate ASCII[33-47] or ACII[58-64]
			switch (rnd.nextInt(2)) {
				case 0:
					result = rnd.nextInt(14) + 33;
					break;
				case 1:
					result = rnd.nextInt(6) + 58;
					break;
				default:
					break;
			}
		} else {
			throw new IllegalArgumentException(
					"The string of allowed characters contains " + temp
							+ " which is invalid modifier");
		}
		return (char) result;
	}

	/**
	 * Returns a string with the given size consisting of randomly generated
	 * characters choosen from the allowedChars input string.
	 * 
	 * @param size
	 *            is the size of the string
	 * @param allowedChars
	 *            is a string that can consist of l,L,d,c (where l is lowercase
	 *            letter, L is uppercase letter d is a digit and c is a special
	 *            character) and tells the method what ASCII chars the string
	 *            can contain.
	 * @return a string with the given size consisting of randomly generated
	 *         characters.
	 * @throws InputSizeException
	 *             if we requset a string with size = 0
	 */
	public static String nextString(int size, String allowedChars)
			throws InputSizeException {
		if (size == 0) {
			throw new InputSizeException();
		}
		if (allowedChars.length() == 0) {
			throw new IllegalArgumentException(
					"Please, input allowed characters");
		}
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < size; i++) {
			builder.append(nextChar(allowedChars));
		}
		return builder.toString();
	}
}