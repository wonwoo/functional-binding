package ml.wonwoo.functionalbinding

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import reactor.core.publisher.Mono
import java.util.function.Consumer


@Configuration(proxyBeanMethods = false)
class RemoteOrdersSinks {

    private val logger: Logger = LoggerFactory.getLogger(javaClass)

    @Bean
    fun remoteOrdersSink(): Consumer<Mono<String>> {
        return Consumer {
            it.map { message ->
                logger.info("kafka message : $message")
            }.subscribe()
        }
    }
}