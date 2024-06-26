package com.engsoft2.valid_subscriptions.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Configuration
public class RabbitMQConfig {

	@Value("${queue-name}")
	public final String QUEUENAME = System.getenv("queue-name");
	public final String FANOUT_EXCHANGE = "subscription.v1.fanout-exchange";

	@Bean
	public Queue queue() {
		return new Queue(QUEUENAME, true, false, false);
	}

	@Bean
	public FanoutExchange exchange(){
		return new FanoutExchange(FANOUT_EXCHANGE, true, false);
	}

	@Bean
	public Binding bindingValidation(FanoutExchange exchange) {
		return BindingBuilder.bind(queue()).to(exchange);
	}

	@Bean
	public MessageConverter jsonMessageConverter() {
		return new Jackson2JsonMessageConverter();
	}

	@Bean
	public RabbitTemplate rabbitTemplate(ConnectionFactory factory, MessageConverter messageConverter) {
		final RabbitTemplate rabbitTemplate = new RabbitTemplate(factory);
		rabbitTemplate.setMessageConverter(messageConverter);
		return rabbitTemplate;
	}

}
