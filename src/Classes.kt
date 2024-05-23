class Student {
    var name: String = ""
        get() = field.uppercase()
        set(value) {
            if (value.isNotBlank()) {
                field = value
            }
        }
}

class Employee(
    var name: String,
    var surname: String,
) {
    val fullName1: String
        get() = "$name $surname"
    val fullName2: String = "$name $surname"
}

class Holder {
    val v1: Int get() = calculate("v1")
    val v2: Int = calculate("v2")

    private fun calculate(propertyName: String): Int {
        println("Calculating $propertyName")
        return 42
    }
}

fun main() {
    val user = Student()
    user.name = "norbert"
    user.name = ""
    user.name = "  "
    println(user.name) // NORBERT

    val employee1 = Employee("Maja", "Markiewicz")
    println(employee1.fullName1) // Maja Markiewicz
    println(employee1.fullName2) // Maja Markiewicz
    employee1.surname = "Moskała"
    println(employee1.fullName1) // Maja Moskała
    println(employee1.fullName2) // Maja Markiewicz

    val h1 = Holder() // Calculating v2
}