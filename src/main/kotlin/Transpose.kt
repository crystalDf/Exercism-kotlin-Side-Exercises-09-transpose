object Transpose {

    fun transpose(input: List<String>): List<String> {

        val maxLength = input.map { it.length }.max() ?: return emptyList()

        val paddingInput = input.map { it.padEnd(maxLength) }

        var transposed = (0 until maxLength)
                .map { index -> paddingInput.joinToString("") { it[index].toString() } }.toMutableList()

        for (i in 0 until maxLength) {
            for (j in paddingInput.indices) {
                if ((transposed[i][j] == ' ')
                        && (!(j until paddingInput.size).map { transposed[i][it] == ' ' }.contains(false))
                        && (!(i until maxLength).map { transposed[it][j] == ' ' }.contains(false))) {
                    transposed[i] = transposed[i].substring(0 until j)
                    break
                }
            }
        }

        return transposed
    }
}
