package com.example.websocket

import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.stereotype.Component
import org.springframework.web.reactive.socket.WebSocketHandler
import org.springframework.web.reactive.socket.WebSocketMessage
import org.springframework.web.reactive.socket.WebSocketSession
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.time.Duration

import java.time.LocalDateTime.now
import java.util.UUID.randomUUID


@Component
class WebSocketController : WebSocketHandler {
    private val json: ObjectMapper = ObjectMapper()

    private val eventFlux: Flux<String> = Flux.generate { sink ->
        val event = Event(randomUUID().toString(), now().toString())
        try {
            sink.next(json.writeValueAsString(event))
        } catch (e: JsonProcessingException) {
            sink.error(e)
        }
    }



    private val intervalFlux: Flux<String> = Flux.interval(Duration.ofMillis(1000L))
        .zipWith(eventFlux) { _, event -> event }

    override fun handle(webSocketSession: WebSocketSession): Mono<Void> {

        return webSocketSession.send(intervalFlux
            .map { payload: String? -> webSocketSession.textMessage(payload!!) })
            .and(
                webSocketSession.receive()
                    .map { obj: WebSocketMessage -> obj.payloadAsText }.log()
            )
    }

}

data class Event(
    val eventId: String,
    val eventDt: String,
)