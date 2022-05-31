package com.example.jpa3

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@SpringBootApplication
@RequestMapping
@RestController
class Jpa3Application(private val dataDao: DataDao) {
    @GetMapping
    fun get(): MutableList<Data> = dataDao.findAll()

    @PostMapping
    fun add() = dataDao.save(Data(null, UUID.randomUUID().toString()))
}

@Entity
class Data(
    @Id
    @GeneratedValue
    val id: Long?,
    val text: String
)

interface DataDao : JpaRepository<Data, Long>, JpaSpecificationExecutor<Data>

fun main(args: Array<String>) {
    runApplication<Jpa3Application>(*args)
}
