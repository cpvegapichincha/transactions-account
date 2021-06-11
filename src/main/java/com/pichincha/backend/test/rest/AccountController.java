package com.pichincha.backend.test.rest;

import com.pichincha.backend.test.dto.AccountDto;
import com.pichincha.backend.test.dto.AccountResponseDto;
import com.pichincha.backend.test.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequestMapping("/accounts")
//todo: Modify class to inject dependencies via constructor
public class AccountController {

  //todo: how do you inject this service without injecting it directly?? Implement it (decouple)
  private final AccountService aService;

  public AccountController(AccountService accountService) {
    this.aService = accountService;
  }

  @GetMapping(value = "/{id}")
  @ResponseStatus(HttpStatus.OK)
  public AccountDto getAccount(@PathVariable Long id) {
    return aService.getAccount(id);
  }


  //todo: get an account with all transactions between amounts of x and y; being x and y pathParameters of the API and filter them via repository not by service.
  //todo: should amounts type be changed? explain why
  //todo: use custom exceptions to throw errors and not exceptions thrown by java; and handle some of them through try and catch and some of them globally (ExceptionHandler)
  //todo: log different kind of levels depending of the information needed (errors, informative, and tracing) the header pass by sleuth should be present in all logs
  //todo: should send an async message to any queue you prefer, this queue must only log the tracing information of the account that is being searched
  //todo: use "mapResponse" of "serviceMapper" in service layer
  //todo: create unit and integration tests
  @GetMapping("/{id}")
  public AccountResponseDto findAccountWithTransactionFilter() {
    return null;
  }

}
