package com.lugonzo.statemachine.services;

import com.lugonzo.statemachine.domain.Payment;
import com.lugonzo.statemachine.domain.PaymentEvent;
import com.lugonzo.statemachine.domain.PaymentState;
import com.lugonzo.statemachine.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.support.DefaultStateMachineContext;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final  StateMachine<PaymentState,PaymentEvent> stateMachineFactory;

    @Override
    public Payment newPayment(Payment payment) {
       payment.setState(PaymentState.NEW);
       return paymentRepository.save(payment);
    }

    @Override
    public StateMachine<PaymentState, PaymentEvent> preAuth(Long paymentId) {
        return null;
    }

    @Override
    public StateMachine<PaymentState, PaymentEvent> authorizePayment(Long paymentId) {
        return null;
    }

    @Override
    public StateMachine<PaymentState, PaymentEvent> declineAuth(Long paymentId) {
        return null;
    }

   /* private StateMachine<PaymentState,PaymentEvent> build(Long paymentId){
        Payment payment = paymentRepository.getById(paymentId);
        StateMachine<PaymentState,PaymentEvent> sm = stateMachineFactory.getStateMachineAccessor(Long.toString(payment.getId()));

        sm.stop();
        sm.getStateMachineAccessor()
                .doWithAllRegions(sma->{
                    sma.resetStateMachine(new DefaultStateMachineContext<>(payment.getState(),null,null));
                });

        sm.start();
        return sm;
    }*/
}
