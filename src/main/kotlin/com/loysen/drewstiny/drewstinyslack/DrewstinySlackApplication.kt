package com.loysen.drewstiny.drewstinyslack

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.ComponentScan

@ComponentScan("com.loysen.drewstiny.drewstinyslack.config")
@SpringBootApplication
class DrewstinySlackApplication

fun main(args: Array<String>) {
    SpringApplication.run(DrewstinySlackApplication::class.java, *args)
}
