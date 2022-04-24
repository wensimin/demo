package com.example.cache

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.Cacheable
import org.springframework.cache.annotation.EnableCaching
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
@EnableCaching
@RestController
@RequestMapping
class CacheApplication {
    @GetMapping
    @Cacheable("cache")
    fun get(param: String?): String {
        println("exec method! :$param")
        return param ?: ""
    }

    @GetMapping("delete")
    @CacheEvict(value = ["cache"], allEntries = true)
    fun deleteAll() {
        println("deleteAll cache")
    }

    @GetMapping("put")
    @CacheEvict(value = ["cache"])
    fun put(param: String?) {
        println("delete key! :$param")
    }
}

fun main(args: Array<String>) {
    runApplication<CacheApplication>(*args)
}


