package com.example.springnative

import org.springframework.data.annotation.Id


data class Store(
    @Id
    var id: Long?,
    val value: String
)

data class SimpleStore(
    val id: Long
)