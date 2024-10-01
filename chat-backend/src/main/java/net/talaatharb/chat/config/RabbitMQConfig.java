package net.talaatharb.chat.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@ConditionalOnProperty(name = {"rabbit.broadcast"}, havingValue = "true")
@Configuration
public class RabbitMQConfig {

    public static final String MESSAGE_QUEUE = "messageQueue";
	public static final String MESSAGE_EXCHANGE = "messageExchange";

	@Bean
    Exchange messageExchange() {
        return ExchangeBuilder.fanoutExchange(MESSAGE_EXCHANGE).durable(true).build();
    }

    @Bean
    Queue messageQueue() {
        return new Queue(MESSAGE_QUEUE, true);
    }

    @Bean
    Binding binding(Queue messageQueue, Exchange messageExchange) {
        return BindingBuilder.bind(messageQueue).to(messageExchange).with("").noargs();
    }
}

