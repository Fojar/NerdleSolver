package nerdlesolver


fun main() {
	println("Nerdle Solver")
}


fun isValidNerdle(s: String): Boolean {

	if (s.length != 8) return false

	val indexOfEquals = s.indexOfEquals() ?: return false

	val left = s.substring(0 until indexOfEquals)
	val right = s.substring(indexOfEquals + 1)

	if (!right.isNumber()) return false


	return true
}


/*
Standard Java string parsing allows leading zeroes, but for this domain we disallow it.
 */
private fun String.isNumber() = this[0] != '0' && toIntOrNull() != null


/*
There must be an equals sign in the string. The farthest to the right it can be is index 6,
because there must be at least 1 digit after it. The farthest to the left it can be is index 4,
because there's no way to get a 4-digit number from an expression with only 3 characters given
the operators available. This returns the index of the first equals sign if it is in that range,
otherwise null. It does not care if there are multiple equals signs.
*/
private fun String.indexOfEquals() = indexOf('=').let { if (it in 4..6) it else null }

