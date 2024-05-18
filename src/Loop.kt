fun main() {
    for (i in 1..5) {
        println(i)
    }
    println("-----------------------")
    for (i in 5 downTo 1) {
        println(i)
    }
    println("-----------------------")
    for (i in 1..5 step 2) {
        println(i)
    }
    println("-----------------------")
    for (i in 5 downTo 1 step 2) {
        println(i)
    }
    println("-----------------------")
    for (i in 1 until 5 step 2) {
        println(i)
    }
    println("-----------------------")
    for (i in 1 until 5) {
        println(i)
    }
    println("-----------------------")
    val names=listOf("Alex","Bob","Celina")
    for (i in 0 until names.size) {
        println("[$i] ${names[i]}")
    }
    println("-----------------------")
    for (i in names.indices) {
        println("[$i] ${names[i]}")
    }
    println("-----------------------")
    for ((i,name) in names.withIndex()) {
        println("[$i] $name")
    }
    println("-----------------------")

    val capitals = mapOf(
        "USA" to "Washington DC",
        "Poland" to "Warsaw",
        "Ukraine" to "Kiev"
    )
    for ((k,v) in capitals) {
        println("$k -> $v")
    }
    println("-----------------------")
    for (entry in capitals.entries) {
        println("${entry.key} -> ${entry.value}")
    }
    println("-----------------------")
    capitals.forEach { (k,v) -> println("$k -> $v") }
    println("-----------------------")
}