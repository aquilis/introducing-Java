package com.sirma.itt.javacourse.intro;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import org.junit.runner.RunWith;

/**
 * Testing the quick sorting method.
 */
@RunWith(Parameterized.class)
public class QuickSorterTest {

	private int[] shuffled;
	private int[] sorted;

	public QuickSorterTest(int[] shuffled, int[] sorted) {
		this.shuffled = shuffled;
		this.sorted = sorted;
	}

	/**
	 * Different input parameters for the sort method.
	 *
	 * @return a collection with shuffled integer arrays and their expected
	 *         condition when sorted
	 */
	@SuppressWarnings("rawtypes")
	@Parameterized.Parameters
	public static Collection arraysForSorting() {
		return Arrays.asList(new Object[][] {
				{ new int[] {5, 2, 88, 43, 12, 98, 3 },
						new int[] {2, 3, 5, 12, 43, 88, 98 } },
				{ new int[] { 100, 0 }, new int[] { 0, 100 } },
				{ new int[] { 5000, 3000, 1000 },
						new int[] { 1000, 3000, 5000 } } });
	}

	/**
	 * Test if the method throws the proper exception if we input an array with
	 * size = 0 or 1.
	 *
	 * @throws InputSizeException
	 *             if the size of the input array is 0 or 1
	 */
	@Test(expected = InputSizeException.class)
	public final void testSmallInputSize() throws InputSizeException {
		int[] arr = {1};
		QuickSorter.sort(arr, 0, 0);
	}

	/**
	 * Test if the proper exception is throws when null input.
	 *
	 * @throws InputSizeException
	 *             if the size of the input array is 0 or 1
	 */
	@Test(expected = NullPointerException.class)
	public final void testNullInput() throws InputSizeException {
		QuickSorter.sort(null, 0, 0);
	}

	/**
	 * Testing the functionallity of the sort method.
	 *
	 * @throws InputSizeException
	 *             if the size of the input arrays is 0 or 1
	 */
	@Test
	public final void testSorting() throws InputSizeException {
		int[] temp = shuffled;
		QuickSorter.sort(temp, 0, temp.length - 1);
		assertArrayEquals(sorted, temp);
	}
}