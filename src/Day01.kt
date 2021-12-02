fun main() {
    fun getPreviousSum(input: List<String>, offset: Int): Int? {
        if(offset < 0) return null
        if(offset - 2 < 0) return null
        return (offset -2..offset).map { input[it].toInt() }.sum()
    }

    val input = readInput("Day01")

    var totalIncrease = 0;
    input.forEachIndexed { index, value ->
        if (index > 0) {
            val previous = input[index - 1]
            if (value.toInt() > previous.toInt()) {
                totalIncrease += 1
            }
        }
    }
    println("Total increase: $totalIncrease")

    totalIncrease = 0
    input.forEachIndexed { index, value ->
        val previousSum = getPreviousSum(input, index -1)
        val sum = getPreviousSum(input, index)

        if(sum !== null && previousSum !== null) {
            if (sum > previousSum) {
                totalIncrease += 1
            }
        }
    }

    println("Total increase: $totalIncrease")
}
