package com.example.springnative

import javax.persistence.Entity
import javax.persistence.Id

@Entity
class Store(
    @Id
    val id: Long,
    val value: String
)