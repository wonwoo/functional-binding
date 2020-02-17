package ml.wonwoo.functionalbinding

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import reactor.core.publisher.Flux
import java.util.function.Function

@Configuration(proxyBeanMethods = false)
class OrdersProcesses {

    private val logger: Logger = LoggerFactory.getLogger(javaClass)

    @Bean
    fun ordersProcess(): Function<Flux<List<String>>, Flux<List<String>>> {
        return Function {
            it.map { message ->
                logger.info("rabbit message : $message")
                val upperCaseMessage = message.map(String::toUpperCase)
                logger.info("sender kafka message : $upperCaseMessage")
                upperCaseMessage
            }
        }
    }
}
