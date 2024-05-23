class User(val name: String) {
    fun cheer() {
        println("Hello my name is $name")
    }
}

var user: User? = null

var user1: User? = User("Cookie")

fun printLengthIfNotNull(str: String?) {
/*    if (str == null) return
    println(str.length)*/
/*    if (str != null) {
        println(str.length) // str smart-casted to String
    }*/
/*    if (str == null) throw Error()
    println(str.length)*/

    //checkNotNull(str)
    requireNotNull(str) // str smart-casted to String
    println(str.length)
}

fun printName(user: User?) {
    val name: String = user?.name ?: "default"
    println(name)
}

fun main() {
    user?.cheer() // does nothing
    println(user?.name) // null
    //println(user?.name.length) // ILLEGAL
    println(user?.name?.length) //null
    user = User("John")
    user?.cheer() // Hello my name is John
    println(user?.name) // John
    println(user?.name?.length) // 4

    println(user1!!.name.length) // 6
    user1 = null
    //println(user1!!.name.length) // throws NullPointerException
    printLengthIfNotNull("Cookie")
    //printLengthIfNotNull(null);

    println("---------------")
    // Elvis operator
    println("A" ?: "B") // A
    println(null ?: "B") // B
    println("A" ?: null) // A
    println(null ?: null) // null

    printName(User("John"))
    printName(null)
}