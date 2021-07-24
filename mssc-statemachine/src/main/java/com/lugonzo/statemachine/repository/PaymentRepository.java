package com.lugonzo.statemachine.repository;

import com.lugonzo.statemachine.domain.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository  extends JpaRepository<Payment,Long> {
}
