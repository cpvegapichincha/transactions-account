package com.pichincha.backend.test.service;


import static com.pichincha.backend.test.Constants.ACCOUNT_NOT_FOUND;
import static lombok.AccessLevel.PRIVATE;

import com.pichincha.backend.test.dto.AccountDto;
import com.pichincha.backend.test.exception.SearchedAccountNotFoundException;
import com.pichincha.backend.test.iservices.IAccountService;
import com.pichincha.backend.test.mapper.ServiceMapper;
import com.pichincha.backend.test.model.Account;
import com.pichincha.backend.test.repository.AccountRepository;
import java.util.List;
import java.util.UUID;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//todo: modify class to inject dependencies not via constructors
@Service
@FieldDefaults(level = PRIVATE)
public class AccountService implements IAccountService {

  @Autowired
  AccountRepository accountRepository;
  @Autowired
  ServiceMapper serviceMapper;


  //todo: use single responsibility principle (mappers in different layer) return account with its transactions and handle with API standards and best practices when account not found OK
  @Override
  public AccountDto getAccount(UUID id) {
    return accountRepository.findById(id)
        .map(account -> serviceMapper.toAccountDto(account))
        .orElseThrow(() -> new SearchedAccountNotFoundException(ACCOUNT_NOT_FOUND));
  }

  @Override
  public Account getDatabaseAccount(UUID id) {
    return accountRepository.findById(id).orElse(Account.builder().build());
  }

  @Override
  public List<Account> getAllAccounts() {
    return accountRepository.findAll();
  }
}
