package nerdlesolver

import kotlin.test.Test
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

class IsValidNerdleTest {

	@Test
	fun `identify valid nerdles`() {

		assertTrue(
			listOf(
				"10*1-8=2",
				"11-4-2=5",
				"1*7+5=12",
			).all(::isValidNerdle)
		)
	}


	@Test
	fun `identify invalid nerdles`() {

		assertTrue(
			listOf(
				"1+1=2",       // String too short.
				"9*8=7654",    // Equals sign too far left.
				"1+2+3+4=",    // Equals sign too far right.
				"1+23=8/5",    // Right side not a number.
				"2+3+5=07",    // Leading zero on the right.
				"12345=12",    // No operators on the left.
				"-1+3*2=5",    // Left starts with an operator.
				"2/2+6*=8",    // Left ends with an operator.
				"12*-3=45",    // Consecutive operators.
			).none(::isValidNerdle)
		)
	}

}
