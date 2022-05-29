package com.example.springnative

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.reactive.asFlow
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate
import org.springframework.r2dbc.core.DatabaseClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*
import javax.validation.Valid

@RestController
@RequestMapping
class StoreController(
    private val storeDao: StoreDao,
    private val r2dbcEntityTemplate: R2dbcEntityTemplate,
    private val databaseClient: DatabaseClient
) {
    @GetMapping
    suspend fun get(@Valid storeQuery: StoreQuery): Flow<Store> {
        return storeDao.findAll().asFlow()
    }

    @GetMapping("simple")
    suspend fun getSimple(@Valid storeQuery: StoreQuery): Flow<SimpleStore> {
//        return r2dbcEntityTemplate.select(SimpleStore::class.java).from(Store::class.simpleName!!).flow()
        return storeDao.findBy().asFlow()
    }


    @GetMapping("query")
    fun getQuery(storeQuery: StoreQuery) = storeQuery

    @PostMapping
    suspend fun add(): Flow<Store> {
        val data = mutableListOf<Store>()
        repeat(100) {
            data.add(Store(null, UUID.randomUUID().toString()))
        }
        return storeDao.saveAll(data).asFlow()
    }
}