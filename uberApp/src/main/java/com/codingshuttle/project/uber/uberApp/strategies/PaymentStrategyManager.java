package com.codingshuttle.project.uber.uberApp.strategies;

import com.codingshuttle.project.uber.uberApp.entities.enums.PaymentMethod;
import com.codingshuttle.project.uber.uberApp.strategies.impl.PaymentStrategyCash;
import com.codingshuttle.project.uber.uberApp.strategies.impl.PaymentStrategyWallet;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PaymentStrategyManager {

    private final PaymentStrategyWallet walletPayment;
    private final PaymentStrategyCash cashPayment;

    public PaymentStrategy paymentStrategy(PaymentMethod paymentMethod){
        return switch (paymentMethod){
            case WALLET -> walletPayment;
            case CASH -> cashPayment;
        };
    }
}
