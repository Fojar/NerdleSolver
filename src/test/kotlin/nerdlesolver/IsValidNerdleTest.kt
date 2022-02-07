package nerdlesolver

import kotlin.test.Test
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

class IsValidNerdleTest {

	@Test
	fun `identify valid nerdles`() {

		val validNerdles = listOf(
			"10*1-8=2",
			"11-4-2=5",
			"1*7+5=12",
		)

		assertTrue(validNerdles.all(::isValidNerdle))
	}


	@Test
	fun `identify invalid nerdles`() {

		val invalidNerdles = listOf(
			"",
			"bleh",
			"1+1=2",
			"1+2+3+4=",
			"2+3+5=07",
		)
		assertTrue(invalidNerdles.none(::isValidNerdle))
	}

}
