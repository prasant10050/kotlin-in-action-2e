package ch02.colors

enum class Color(
    val r: Int,
    val g: Int,
    val b: Int
) {
    RED(255, 0, 0),
    ORANGE(255, 165, 0),
    YELLOW(255, 255, 0),
    GREEN(0, 255, 0),
    BLUE(0, 0, 255),
    INDIGO(75, 0, 130),
    VIOLET(238, 130, 238);

    fun rgb() = (r * 256 + g) * 256 + b
}

fun getMnemonic(color: Color) = when (color) {
    Color.RED -> "Richard"
    Color.ORANGE -> "Of"
    Color.YELLOW -> "York"
    Color.GREEN -> "Gave"
    Color.BLUE -> "Battle"
    Color.INDIGO -> "In"
    Color.VIOLET -> "Vain"
}

fun measureColor() = Color.ORANGE

fun getWarmthFromSensor(): String {
    return when (val color = measureColor()) {
        Color.RED, Color.ORANGE, Color.YELLOW -> "warm (red=${color.r})"
        Color.GREEN -> "neutral"
        Color.BLUE, Color.INDIGO, Color.VIOLET -> "cold (blue=${color.b})"
    }
}

fun mix(c1:Color,c2:Color)=when(setOf(c1,c2)){
    setOf(Color.RED,Color.YELLOW)->Color.ORANGE
    setOf(Color.YELLOW,Color.BLUE)->Color.GREEN
    setOf(Color.BLUE,Color.VIOLET)->Color.INDIGO
    else -> throw Exception("Dirty color")
}
