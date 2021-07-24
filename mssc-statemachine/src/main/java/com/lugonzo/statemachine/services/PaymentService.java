package com.lugonzo.statemachine.services;

import com.lugonzo.statemachine.domain.Payment;
import com.lugonzo.statemachine.domain.PaymentEvent;
import com.lugonzo.statemachine.domain.PaymentState;
import org.springframework.statemachine.StateMachine;

public interface PaymentService {
    Payment newPayment(Payment payment);

    StateMachine<PaymentState, PaymentEvent> preAuth(Long paymentId);

    StateMachine<PaymentState, PaymentEvent> authorizePayment(Long paymentId);

    StateMachine<PaymentState, PaymentEvent> declineAuth(Long paymentId);
}
