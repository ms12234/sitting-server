package com.sitting.server

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

@SpringBootApplication
@EnableMongoRepositories
object ServerApplication {

    @JvmStatic
    fun main(args: Array<String>) {
        SpringApplication.run(ServerApplication::class.java, *args)
    }
}
