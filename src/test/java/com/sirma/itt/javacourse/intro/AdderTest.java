package com.sirma.itt.javacourse.intro;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import java.util.Arrays;
import java.util.Collection;
import org.junit.runners.Parameterized;
import org.junit.runner.RunWith;

/**
 * A parameterized class testing the functionallity of the
 * adder class.
 */
@RunWith(Parameterized.class)
public class AdderTest {

	private String a;
	private String b;
	private String expected;

	/**
	 * The constructor of the parameterized class.
	 *
	 * @param a
	 *            is the first input string
	 * @param b
	 *            is the second input string
	 * @param exp
	 *            is the expected result from the additiobn
	 */
	public AdderTest(String a, String b, String exp) {
		this.a = a;
		this.b = b;
		this.expected = exp;
	}

	/**
	 * The parameters collection for the test.
	 *
	 * @return a collection with different input parameters and the expected
	 *         result.
	 */
	@SuppressWarnings("rawtypes")
	@Parameterized.Parameters
	public static Collection addition() {
		return Arrays.asList(new Object[][] { { "1000", "34", "1034" },
				{ "999", "1", "1000" }, { "300", "300", "600" },
				{ "9", "1", "10" }, { "300", "7000", "7300" },
				{ "1999", "1", "2000" }, { "0", "99", "99" } });
	}

	/**
	 * The main test case. Testing the method with different input strings.
	 *
	 * @throws InputSizeException
	 *             if the size of one of the input strings is 0.
	 */
	@Test
	public final void testAddition() throws InputSizeException {
		assertEquals(expected, Adder.add(a, b));
	}

	/**
	 * Test if the method throws the proper exception when we input empty
	 * strings as parameters.
	 *
	 * @throws InputSizeException
	 *             if the input strings have a size of zero
	 */
	@Test(expected = InputSizeException.class)
	public final void testEmpty() throws InputSizeException {
		Adder.add("", "");
	}
}