package com.example.ktorm

import com.fasterxml.jackson.databind.node.JsonNodeFactory
import com.fasterxml.jackson.databind.node.ObjectNode
import org.ktorm.database.Database
import org.ktorm.dsl.from
import org.ktorm.dsl.insert
import org.ktorm.dsl.map
import org.ktorm.dsl.select
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping
class DataController(private val database: Database) {


    @GetMapping
    fun get(): List<ObjectNode> {
        return database.from(Data).select().map {
            JsonNodeFactory.instance.objectNode().apply {
                put("id", it[Data.id])
                put("text", it[Data.text])
            }
        }
    }

    @PostMapping
    fun post() = database.insert(Data) {
        set(it.text, UUID.randomUUID().toString())
    }
}