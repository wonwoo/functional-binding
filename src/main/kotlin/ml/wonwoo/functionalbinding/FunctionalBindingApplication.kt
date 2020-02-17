package ml.wonwoo.functionalbinding

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class FunctionalBindingApplication {

    @Bean
    fun init(ordersProducers: OrdersProducers): CommandLineRunner {
        return CommandLineRunner {
            ordersProducers.ordersSender(listOf("foo", "bar"))
        }
    }
}

fun main(args: Array<String>) {
    runApplication<FunctionalBindingApplication>(*args)
}
