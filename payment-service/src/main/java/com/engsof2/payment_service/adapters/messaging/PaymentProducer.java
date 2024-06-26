package com.engsof2.payment_service.adapters.messaging;

import com.engsof2.payment_service.adapters.config.RabbitMQConfig;
import com.engsof2.payment_service.application.dto.PaymentDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PaymentProducer {

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public PaymentProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendPaymentMessage(PaymentDTO payment) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.QUEUE_REGISTER, payment);
        rabbitTemplate.convertAndSend(RabbitMQConfig.FANOUT_EXCHANGE, payment);
    }
}
