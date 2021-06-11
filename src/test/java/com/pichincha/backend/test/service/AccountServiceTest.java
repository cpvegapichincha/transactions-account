package com.pichincha.backend.test.service;

//import static org.hamcrest.Matchers.hasSize;
//import static org.hamcrest.Matchers.notNullValue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.pichincha.backend.test.dto.AccountDto;
import com.pichincha.backend.test.dto.NewTransactionDto;
import com.pichincha.backend.test.dto.TransactionDto;
import com.pichincha.backend.test.model.Account;
import com.pichincha.backend.test.repository.AccountRepository;
import java.time.LocalDateTime;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class AccountServiceTest {

  @Autowired
  AccountRepository accountRepository;

  @Autowired
  AccountService accountService;

  @Test
  void shouldReturnCreatedAccount() {
    Account account = new Account();
    account.setNumber("Test number");
    account.setType("Test type");
    LocalDateTime creationDate = LocalDateTime.of(2018, 5, 20, 20, 51, 16);
    account.setCreationDate(creationDate);
    accountRepository.save(account);

    AccountDto accountDto = accountService.getAccount(account.getId());

    assertNotNull(accountDto);
    assertEquals("Test type", accountDto.getType());
    assertEquals("Test number", accountDto.getNumber());
    assertEquals(creationDate, accountDto.getCreationDate());
  }

  @Test
  void shouldReturnNullForNotExistingAccount() {
    AccountDto accountDto = accountService.getAccount(123L);
    assertNull(accountDto);
  }


  @Test
  void shouldAddTransaction() {
    Account account = createTestAccount();

    NewTransactionDto transaction = new NewTransactionDto();
    transaction.setAccountId(account.getId());
    transaction.setType("Type");
    transaction.setComment("Comment");
    Long transactionId = accountService.addTransaction(transaction);

    assertNotNull(transactionId, "Transaction id shouldn't be null");
  }

  private Account createTestAccount() {
    Account account = new Account();
    account.setNumber("Test Number");
    account.setType("Test type");
    LocalDateTime creationDate = LocalDateTime.of(2018, 5, 20, 20, 51, 16);
    account.setCreationDate(creationDate);
    accountRepository.save(account);
    return account;
  }

  @Test
  void shouldReturnAddedTransaction() {
    Account account = createTestAccount();

    NewTransactionDto transaction = new NewTransactionDto();
    transaction.setAccountId(account.getId());
    transaction.setType("Type");
    transaction.setComment("Comment");

    accountService.addTransaction(transaction);

    List<TransactionDto> transactions = accountService.getTransactionsForAccount(account.getId());

    assertEquals(1, transactions.size(), "There should be one transaction");
    assertEquals("Type", transactions.get(0).getType());
    assertEquals("Comment", transactions.get(0).getComment());
  }
}
