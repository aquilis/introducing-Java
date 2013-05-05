package com.sirma.itt.javacourse.intro;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * Testing the random string generating.
 */
@RunWith(Parameterized.class)
public class StringGeneratorTest {
	private String testExplain;
	private String modifiers;

	/**
	 * Constrcutor taking the arguments for the test.
	 *
	 * @param testExplain
	 *            is a brief explanation of the current test, printed on the
	 *            console.
	 * @param modifiers
	 *            are the modifiers for the generated string. See
	 *            StringGenerator implementation for details.
	 */
	public StringGeneratorTest(String testExplain, String modifiers) {
		this.testExplain = testExplain;
		this.modifiers = modifiers;
	}

	/**
	 * All parameters for the test.
	 * 
	 * @return A collection with a brief explanation for the test and strings
	 *         with different modifiers for the method.
	 */
	@SuppressWarnings("rawtypes")
	@Parameterized.Parameters
	public static Collection testParameters() {
		return Arrays.asList(new Object[][] {
				{ "Testing with all supported characters: ", "c,l,L,d" },
				{ "Testing with special characters only: ", "c" },
				{ "Testing with digits only: ", "d" },
				{ "Testing with uppercase letters only: ", "L" },
				{ "Testing with lowercase + uppercase letters: ", "L,l" },
				{ "Testing letters + digits: ", "L,l,d" } });
	}

	/**
	 * Make several tests with different input strings and print the short
	 * explanation about the current text on the console line.
	 * 
	 * @throws InputSizeException
	 *             if we requst the method to return a string with size = 0
	 */
	@Test
	public final void testModifiers() throws InputSizeException {
		System.out.println(testExplain
				+ StringGenerator.nextString(10, modifiers));
	}

	/**
	 * Check if the method throws the proper exception when requset zero size.
	 * 
	 * @throws InputSizeException
	 *             if we request the method to return a string with size = 0
	 */
	@Test(expected = InputSizeException.class)
	public final void test() throws InputSizeException {
		StringGenerator.nextString(0, "l");
	}

	/**
	 * Test if the method throws the proper exception when we don't input any
	 * modifiers for allowed chars.
	 * 
	 * @throws InputSizeException
	 *             if we request the method to return a string with size = 0.
	 */
	@Test(expected = IllegalArgumentException.class)
	public final void testNoModifiers() throws InputSizeException {
		StringGenerator.nextString(5, "");
	}

	/**
	 * Test if the method throws the proper exception when we input illegal
	 * modifiers for the allowed chars.
	 * 
	 * @throws InputSizeException
	 *             if we request the method to return a string with size = 0.
	 */
	@Test(expected = IllegalArgumentException.class)
	public final void testIllegalModifiers() throws InputSizeException {
		StringGenerator.nextString(5, "jfgjfj");
	}
}