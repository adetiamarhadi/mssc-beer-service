package com.github.adetiamarhadi.msscbeerservice.services.order;

import com.github.adetiamarhadi.brewery.model.events.ValidateOrderRequest;
import com.github.adetiamarhadi.brewery.model.events.ValidateOrderResult;
import com.github.adetiamarhadi.msscbeerservice.config.JmsConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class BeerOrderValidationListener {

    private final BeerOrderValidator validator;
    private final JmsTemplate jmsTemplate;

    @JmsListener(destination = JmsConfig.VALIDATE_ORDER_QUEUE)
    public void listen(ValidateOrderRequest validateOrderRequest) {

        Boolean isValid = this.validator.validateOrder(validateOrderRequest.getBeerOrderDto());

        this.jmsTemplate.convertAndSend(JmsConfig.VALIDATE_ORDER_RESPONSE_QUEUE, ValidateOrderResult.builder()
                .isValid(isValid)
                .orderId(validateOrderRequest.getBeerOrderDto().getId())
                .build());
    }
}
