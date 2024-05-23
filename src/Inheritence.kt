open class Shape {
    open fun draw() {}
    fun fill() {}
    open val vertexCount: Int = 0
}

class Circle() : Shape() {
    override fun draw() {}
}

open class Rectangle : Shape() {
    final override fun draw() {}  //  prohibit re-overriding, use final
    override val vertexCount: Int = 4
}

interface ShapeEnhance {
    val vertexCount: Int
}

class RectangleEnhance(override val vertexCount: Int = 4) : ShapeEnhance {}

class Polygon : ShapeEnhance {
    override val vertexCount: Int = 4
}

// Derived class initialization order
open class Base(val name: String) {

    init {
        println("Initializing a base class")
    }

    open val size: Int =
        name.length.also { println("Initializing size in the base class: $it") }
}

class Derived(
    name: String,
    val lastName: String,
) : Base(name.replaceFirstChar { it.uppercase() }
    .also { println("Argument for the base class: $it") }) {

    init {
        println("Initializing a derived class")
    }

    override val size: Int =
        (super.size + lastName.length).also { println("Initializing size in the derived class: $it") }
}

// Constructing the derived class("hello", "world")
// Argument for the base class: Hello
// Initializing a base class
// Initializing size in the base class: 5
// Initializing a derived class
// Initializing size in the derived class: 10


open class Base1(p: Int)

class Derived1(p: Int) : Base1(p)

class Derived2 : Base1 {
    constructor(p: Int) : super(p)
}

// Overriding properties
open class Shape1 {
    open val vertexCount: Int = 0
}

class Rectangle1 : Shape1() {
    override val vertexCount = 4
}

interface Shape2 {
    val vertexCount: Int
}

// Always has 4 vertices
class Rectangle2(override val vertexCount: Int = 4) : Shape2

class Polygon1 : Shape2 {
    override var vertexCount: Int = 4
}


// Calling the superclass implementation
open class Rectangle3 {
    open fun draw() { println("Drawing a rectangle") }
    val borderColor: String get() = "black"
}

class FilledRectangle : Rectangle3() {
    override fun draw() {
        super.draw()
        println("Filling the rectangle")
    }

    val fillColor: String get() = super.borderColor
}

class FilledRectangle1: Rectangle3() {
    override fun draw() {
        val filler = Filler()
        filler.drawAndFill()
    }

    inner class Filler {
        fun fill() { println("Filling") }
        fun drawAndFill() {
            super@FilledRectangle1.draw() // Calls Rectangle's implementation of draw()
            fill()
            println("Drawn a filled rectangle with color ${super@FilledRectangle1.borderColor}") // Uses Rectangle's implementation of borderColor's get()
        }
    }
}