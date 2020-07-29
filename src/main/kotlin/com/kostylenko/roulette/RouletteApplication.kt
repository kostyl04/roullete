package com.kostylenko.roulette

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.transaction.annotation.EnableTransactionManagement

@SpringBootApplication
@EnableTransactionManagement
class RouletteApplication

fun main(args: Array<String>) {
	runApplication<RouletteApplication>(*args)
}
