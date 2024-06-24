package com.engsof2.payment_service.adapters.messaging;

import com.engsof2.payment_service.application.dto.PaymentDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PaymentProducer {

    private final RabbitTemplate rabbitTemplate;
    private final String queueRegister;
    private final String queueValidate;

    @Autowired
    public PaymentProducer(RabbitTemplate rabbitTemplate,
                           @Value("${rabbitmq.queue.register}") String queueRegister,
                           @Value("${rabbitmq.queue.validate}") String queueValidate) {
        this.rabbitTemplate = rabbitTemplate;
        this.queueRegister = queueRegister;
        this.queueValidate = queueValidate;
    }

    public void sendPaymentMessage(PaymentDTO payment) {
        rabbitTemplate.convertAndSend(queueRegister, payment);
        rabbitTemplate.convertAndSend(queueValidate, payment);
    }
}