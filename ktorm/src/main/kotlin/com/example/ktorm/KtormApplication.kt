package com.example.ktorm

import org.ktorm.database.Database
import org.ktorm.logging.ConsoleLogger
import org.ktorm.logging.LogLevel
import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.varchar
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import javax.sql.DataSource

@SpringBootApplication
class KtormApplication {
    @Bean
    fun database(dataSource: DataSource): Database {
        return Database.connectWithSpringSupport(dataSource, logger = ConsoleLogger(LogLevel.DEBUG))
    }

}

object Data : Table<Nothing>("data") {
    val id = int("id").primaryKey()
    val text = varchar("text")
}

fun main(args: Array<String>) {
    runApplication<KtormApplication>(*args)
}
