package com.engsof2.payment_service.adapters.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String QUEUE_REGISTER = "subscription.v1.payment-register";
    public static final String QUEUE_VALIDATION = "subscription.v1.payment-validate";
    public static final String FANOUT_EXCHANGE = "subscription.v1.fanout-exchange";

    @Bean
    public Queue queueValidation() {
        return new Queue(QUEUE_VALIDATION, true);
    }

    @Bean
    public Queue queueRegister() {
        return new Queue(QUEUE_REGISTER, true);
    }

    @Bean
    public TopicExchange exchange(){
        return new TopicExchange(FANOUT_EXCHANGE, true, false);
    }

    @Bean
    public Binding bindingValidation(TopicExchange exchange) {
        return BindingBuilder.bind(queueValidation()).to(exchange).with(queueValidation().getName());
    }

    @Bean
    public Binding bindingRegister(TopicExchange exchange) {
        return BindingBuilder.bind(queueRegister()).to(exchange).with(queueRegister().getName());
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
