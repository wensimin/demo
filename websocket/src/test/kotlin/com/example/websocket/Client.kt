package com.example.websocket

import org.springframework.web.reactive.socket.WebSocketMessage
import org.springframework.web.reactive.socket.client.ReactorNettyWebSocketClient
import reactor.core.publisher.Mono
import java.net.URI
import java.time.Duration

fun main() {
    ReactorNettyWebSocketClient().execute(
        URI.create("ws://localhost:8080/event-emitter")
    ) { session ->
        session.send(
            Mono.just(session.textMessage("event-spring-reactive-client-websocket"))
        )
            .thenMany(
                session.receive()
                    .map(WebSocketMessage::getPayloadAsText)
                    .log()
            )
            .then()
    }
        .block(Duration.ofSeconds(10L))
}
