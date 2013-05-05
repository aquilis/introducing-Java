package com.sirma.itt.javacourse.intro;

/**
 * Exception thrown when the length of the input parameter (array, string, list)
 * is too big/small.
 */
class InputSizeException extends Exception {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * No parameters constructor.
	 */
	public InputSizeException() {
		super("The size (length) of the input is outside the expected borders");
	}

	/**
	 * A constrctor taking a string as a specific message for the exception
	 *
	 * @param message
	 *            is a specific explanation for the exception.
	 */
	public InputSizeException(String message) {
		super(message);
	}

	/**
	 * A 2-parameters constructor.
	 * 
	 * @param min
	 *            is the minimal expected size of the input
	 * @param max
	 *            is the maximal expected size of the input
	 */
	public InputSizeException(int min, int max) {
		super("The size (length) of the input is outside the borders " + min
				+ " to " + max);
	}
}