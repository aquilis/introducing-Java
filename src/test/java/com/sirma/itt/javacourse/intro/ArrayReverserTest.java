package com.sirma.itt.javacourse.intro;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * Test the reverse array method.
 */
@RunWith(Parameterized.class)
public class ArrayReverserTest {

	private int[] normal;
	private int[] reversed;

	/**
	 * A constrcutor taking the input partameters for the parameterized class.
	 *
	 * @param normal
	 *            is the initial state of the array
	 * @param reversed
	 *            is the reversed state of the array
	 */
	public ArrayReverserTest(int[] normal, int[] reversed) {
		this.normal = normal;
		this.reversed = reversed;
	}

	/**
	 * Different input array parameters for the test.
	 *
	 * @return a collection with the array and its reversed expected
	 *         condition
	 */
	@SuppressWarnings("rawtypes")
	@Parameterized.Parameters
	public static Collection inputs() {
		return Arrays
				.asList(new Object[][] {
						{ new int[] { 0, 1, 2, 3, 4 },
								new int[] { 4, 3, 2, 1, 0 } },
						{ new int[] { 0, 0, 0 }, new int[] { 0, 0, 0 } },
						{ new int[] { 33, 66, 77, 99 },
								new int[] { 99, 77, 66, 33 } } });
	}

	/**
	 * Test the array reversion.
	 */
	@Test
	public final void test() {
		int[] temp = normal;
		ArrayReverser.reverseArray(temp);
		assertArrayEquals(temp, reversed);
	}

	/**
	 * Test the string reversion.
	 */
	@Test
	public void testReverseString() {
		String expected = "eman";
		String reversed = ArrayReverser.reverseString("name");
		assertEquals(expected, reversed);
	}
}