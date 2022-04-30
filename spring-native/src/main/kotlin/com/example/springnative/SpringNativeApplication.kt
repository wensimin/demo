package com.example.springnative

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.nativex.hint.TypeHint

@SpringBootApplication
@TypeHint(types = [Like::class])
class SpringNativeApplication

fun main(args: Array<String>) {
    runApplication<SpringNativeApplication>(*args)
}
