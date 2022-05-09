package com.example.springnative

import com.github.wensimin.jpaspecplus.findBySpec
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*
import javax.validation.Valid

@RestController
@RequestMapping
class StoreController(private val storeDao: StoreDao) {
    @GetMapping
    fun get(@Valid storeQuery: StoreQuery): MutableList<Store> {
        return storeDao.findBySpec(storeQuery)
    }

    @GetMapping("query")
    fun getQuery(storeQuery: StoreQuery) = storeQuery

    @PostMapping
    suspend fun add() {
        listOf(Store(1, UUID.randomUUID().toString()), Store(2, UUID.randomUUID().toString()))
            .forEach { storeDao.save(it) }
    }
}