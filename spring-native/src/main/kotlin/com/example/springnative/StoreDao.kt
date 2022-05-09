package com.example.springnative


import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Flux

interface StoreDao : ReactiveCrudRepository<Store, Long> {
    fun findBy(): Flux<SimpleStore>
}