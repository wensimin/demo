package com.example.websocket

import reactor.core.publisher.Flux
import java.lang.Thread.sleep
import java.util.function.Consumer

class Logger {
    private lateinit var listener: Consumer<String?>

    fun flux(): Flux<String> {
        return Flux.create {
            listener = Consumer { t -> if (t == null) it.complete() else it.next(t) }
        }
    }

    private fun onPacket(packet: String?) {
        listener.accept(packet)
    }

    fun startLog(input: String) {
        repeat(10) {
            sleep(1000)
            onPacket("$input $it")
        }
        onPacket(null)
    }
}