package com.sirma.itt.javacourse.intro;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import java.util.Arrays;
import java.util.Collection;
import org.junit.runners.Parameterized;
import org.junit.runner.RunWith;

/**
 * Testing the center of weight class.
 */
@RunWith(Parameterized.class)
public class CenterOfWeightArrayTest {

	private int[] arrInput;
	private int expected;

	/**
	 * Constructor taking the parameters for the tests.
	 *
	 * @param in
	 *            is the input array to be tested
	 * @param ex
	 *            is the expected index of the center of weight of the input
	 *            array
	 */
	public CenterOfWeightArrayTest(int[] in, int ex) {
		this.arrInput = in;
		this.expected = ex;
	}

	/**
	 * The collection with the parameters
	 *
	 * @return a collection with the input array and its expected center of
	 *         weight for the test case
	 */
	@SuppressWarnings("rawtypes")
	@Parameterized.Parameters
	public static Collection arrays() {
		return Arrays.asList(new Object[][] {
				{ new int[] { 13, 1, 4, 100, 2, 1, 12 }, 4 },
				{ new int[] { 0, 0, 0, 0, 0, 0, 5, 0 }, 7 },
				{ new int[] { 0, 0, 0, 0, 0 }, 3 },
				{ new int[] { 0, 1, 11, 0, 1 }, 3 } });
	}

	/**
	 * Main test case testing the method with a variety of input parameters.
	 *
	 * @throws InputSizeException
	 *             if the input array has a size <= 2
	 */
	@Test
	public final void testCenter() throws InputSizeException {
		assertEquals(CenterOfWeightArray.findCenter(arrInput), expected);
	}

	/**
	 * Test with an input array of just two or less elements. (no center of
	 * weight)
	 *
	 * @throws InputSizeException
	 *             if the input array has a size <= 2
	 */
	@Test(expected = InputSizeException.class)
	public final void testInputSize() throws InputSizeException {
		int[] arr = { 1, 2 };
		CenterOfWeightArray.findCenter(arr);
	}
}
