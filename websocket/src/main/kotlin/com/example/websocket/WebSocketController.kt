package com.example.websocket

import org.springframework.stereotype.Component
import org.springframework.web.reactive.socket.WebSocketHandler
import org.springframework.web.reactive.socket.WebSocketSession
import reactor.core.publisher.Mono
import kotlin.concurrent.thread


@Component
class WebSocketController : WebSocketHandler {

    override fun handle(webSocketSession: WebSocketSession): Mono<Void> {
        val logger = Logger()
        return webSocketSession.send(logger.flux()
            .map { webSocketSession.textMessage(it) }
            // 目前的api不支持send中嵌套close 见 https://github.com/reactor/reactor-netty/issues/478
            .doOnComplete { throw RuntimeException() })
            .onErrorResume { webSocketSession.close() }
            .and(
                webSocketSession.receive().log()
                    .map { it.payloadAsText }
                    .map { thread(true){logger.startLog(it)} }
                    .doOnComplete { println("client complete") }
            )
    }


}

