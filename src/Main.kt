import ch02.colors.Color
import ch02.colors.getMnemonic
import ch02.colors.getWarmthFromSensor
import ch02.colors.mix
import geometry.shapes.Rectangle
import geometry.shapes.createUnitSquare

fun main() {
    val person = Person("Bob", true, 0.0)
    println(person.name)

    println(person.isStudent)

    person.isStudent = false
    println(person.isStudent)

    println(person.isSalary)
    person.isSalary = 100.0
    println(person.isSalary)

    /*    val rectangle = Rectangle(10, 20);
        println(rectangle.area)*/

    val company = Company()
    println(company.name)
    company.name = "GeeksforGeeks"
    println(company.name)

    println(Rectangle(3, 4).isSquare)
    println(createUnitSquare().isSquare)

    println(Color.RED.rgb())

    println(getMnemonic(Color.BLUE))
    println(getWarmthFromSensor())

    println(mix(Color.BLUE,Color.YELLOW))
}

class Person(
    val name: String,
    var isStudent: Boolean,
    var isSalary: Double
)

/*class Rectangle(val width: Int, val height: Int) {
    val area: Int
        get() = width * height
}*/

class Company {
    var name: String = "default value"
        get() = field
        set(value) {
            field = value
        }
}