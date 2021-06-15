package com.pichincha.backend.test.rest;

import com.pichincha.backend.test.dto.AccountDto;
import com.pichincha.backend.test.iservices.IAccountService;
import com.pichincha.backend.test.model.Account;
import com.pichincha.backend.test.service.AccountService;
import java.util.List;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts")
//todo: Modify class to inject dependencies via constructor OK
public class AccountController {

  //todo: how do you inject this service without injecting it directly?? Implement it (decouple) OK
  private final IAccountService iAccountService;

  public AccountController(AccountService accountService) {
    this.iAccountService = accountService;
  }

  @GetMapping(value = "/{id}")
  @ResponseStatus(HttpStatus.OK)
  public AccountDto getAccount(@PathVariable String id) {
    return iAccountService.getAccount(UUID.fromString(id));
  }

  //helper not in test
  @GetMapping()
  public List<Account> getAllAccounts(){
    return iAccountService.getAllAccounts();
  }
}
