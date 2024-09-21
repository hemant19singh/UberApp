package com.codingshuttle.project.uber.uberApp.services;

import com.codingshuttle.project.uber.uberApp.entities.Payment;
import com.codingshuttle.project.uber.uberApp.entities.Ride;
import com.codingshuttle.project.uber.uberApp.entities.enums.PaymentStatus;

public interface PaymentService {

    Payment createNewPayment(Ride ride);

    void processPayment(Ride ride);

    void updatePaymentStatus(Payment payment, PaymentStatus paymentStatus);

}
