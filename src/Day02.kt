fun main() {

    fun sumByKey(key: String, input: List<List<String>>): Int {
        var sum = 0

        input.forEach {
            if (it.get(0).equals(key)) {
                sum += it.get(1).toInt()
            }
        }
        return sum
    }

    val input = readInput("Day02")

    val formatted = input.map {
        it.split(" ")
    }

    val forward = sumByKey("forward", formatted)
    val down = sumByKey("down", formatted)
    val up = sumByKey("up", formatted)

    var result = (down - up) * forward

    println("result: $result")

    var aim = 0
    var depth = 0
    formatted.forEach {
        when (it.get(0)) {
            "forward" -> depth += it.get(1).toInt() * aim
            "up" -> aim -= it.get(1).toInt()
            "down" -> aim += it.get(1).toInt()
        }
    }

    result = depth * forward

    println("result $result")

}