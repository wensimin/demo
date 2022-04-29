inline fun <reified T> create() = T::class.constructors.first().call()

fun main() {
    var string = "q"
    println("s:$string")
    string = create()
    println("s:$string")
    //RUNTIME EXCEPTION
    val int = create<Int>()
    println("i:$int")

}