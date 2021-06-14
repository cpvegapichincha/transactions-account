package com.pichincha.backend.test.iservices;

import com.pichincha.backend.test.dto.AccountDto;
import com.pichincha.backend.test.dto.AccountResponseDto;
import com.pichincha.backend.test.model.Account;
import java.util.List;
import java.util.UUID;

public interface IAccountService {

  AccountDto getAccount(UUID id);

  Account getDatabaseAccount(UUID id);

  List<Account> getAllAccounts();
}
