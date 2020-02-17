package ml.wonwoo.functionalbinding

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.concurrent.BlockingQueue
import java.util.concurrent.LinkedBlockingQueue
import java.util.function.Supplier

@Configuration(proxyBeanMethods = false)
class OrdersProducers {

    private val ordersEvent: BlockingQueue<List<String>> = LinkedBlockingQueue<List<String>>()

    @Bean
    fun ordersSender(): Supplier<List<String>> {
        return Supplier {
            ordersEvent.poll()
        }
    }

    fun ordersSender(order: List<String>): Boolean {
        return ordersEvent.offer(order)
    }

}