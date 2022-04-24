import java.lang.Thread.sleep
import kotlin.concurrent.thread

/**
 * 实验实现读的同时清除stringBuffer的原子操作
 */

fun main() {
    val buffer = StringBuffer()
    val repeat = 1000000
    val write = thread(true) {
        repeat(repeat) {
            buffer.append(it % 10)
        }
        sleep(1000)
    }
    val rs = StringBuilder()
    thread(true) {
        while (write.isAlive) {
            rs.append(buffer.readAndClear())
        }
        println(rs.length == repeat)
    }
}

/**
 * 组合了下读取和清空的操作
 */
fun StringBuffer.readAndClear(): String {
    synchronized(this) {
        val rs = this.toString()
        this.setLength(0)
        return rs
    }
}
