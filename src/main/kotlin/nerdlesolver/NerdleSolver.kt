package nerdlesolver


fun main() {
	println("Nerdle Solver")


	while (true) {
		print("Guess: ")
		val input = readln()
		if (input.isEmpty()) break

		println("is valid: ${isValidNerdle(input)}")

	}


}

const val operators = "+-*/"


fun isValidNerdle(s: String): Boolean {

	if (s.length != 8) return false

	val indexOfEquals = s.validIndexOfEquals() ?: return false

	val left = s.substring(0 until indexOfEquals)
	val right = s.substring(indexOfEquals + 1)

	if (!right.isNumber()) return false

	val operatorIndices = left.operatorIndices()

	// There should be at least one operator.
	if (operatorIndices.isEmpty()) return false

	// There shouldn't be an operator at the beginning or end.
	if (operatorIndices.first() == 0 || operatorIndices.last() == left.lastIndex) return false

	// Operators can't be consecutive.
	if (operatorIndices.zipWithNext().any { it.second - it.first == 1 }) return false


	return true
}


// Standard Java string parsing allows leading zeroes, but for this domain we disallow it.
fun String.isNumber() = this[0] != '0' && toIntOrNull() != null


/*
There must be an equals sign in the string. The farthest to the right it can be is index 6,
because there must be at least 1 digit after it. The farthest to the left it can be is index 4,
because there's no way to get a 4-digit number from an expression with only 3 characters given
the operators available. This returns the index of the first equals sign if it is in that range,
otherwise null. It does not care if there are multiple equals signs.
*/
fun String.validIndexOfEquals() = indexOf('=').let { if (it in 4..6) it else null }


// Yields the indices of all the operator characters in the string.
fun String.operatorIndices() = indices.filter { this[it] in operators }
