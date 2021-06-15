package com.pichincha.backend.test.repository;

import com.pichincha.backend.test.model.Transaction;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, UUID> {

  List<Transaction> findByAccountId(UUID accountId);

  List<Transaction> findByAccountIdAndAmountBetween(UUID account, double minimum,
      double maximum);

}
