package com.example.websocket

import reactor.core.publisher.Flux
import reactor.core.publisher.FluxSink
import java.lang.Thread.sleep

class Logger {
    private lateinit var sink: FluxSink<String>
    fun flux(): Flux<String> {
        return Flux.create {
            sink = it
        }
    }



    fun startLog(input: String) {
        repeat(10) {
            sleep(1000)
            sink.next("$input $it")
        }
        sink.complete()
    }
}