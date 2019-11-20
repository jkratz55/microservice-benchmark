package io.jkratz.employee

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class EmployeeReactiveApplication

fun main(args: Array<String>) {
	runApplication<EmployeeReactiveApplication>(*args)
}
