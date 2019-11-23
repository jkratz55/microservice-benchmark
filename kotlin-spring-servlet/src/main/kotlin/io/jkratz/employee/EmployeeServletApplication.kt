package io.jkratz.employee

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.concurrent.*

@SpringBootApplication
class EmployeeServletApplication

fun main(args: Array<String>) {
	runApplication<EmployeeServletApplication>(*args)
}

@Configuration
class Config {
	@Bean("outboundHttpPool")
	fun outboundHttpPool(): ExecutorService {

		val executor = ThreadPoolExecutor(
				200,
				200,
				0,
				TimeUnit.MILLISECONDS,
				SynchronousQueue<Runnable>()
		)
		return executor
	}
}
