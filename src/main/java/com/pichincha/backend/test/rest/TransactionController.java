package com.pichincha.backend.test.rest;

import static org.springframework.http.HttpStatus.CREATED;

import com.pichincha.backend.test.dto.AccountResponseDto;
import com.pichincha.backend.test.dto.NewTransactionDto;
import com.pichincha.backend.test.dto.TransactionDto;
import com.pichincha.backend.test.iservices.ITransactionService;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping("/accounts")
public class TransactionController {

  @Autowired
  ITransactionService iTransactionService;

  @PostMapping("{accountId}/transactions")
  @ResponseStatus(CREATED)
  public UUID addTransaction(@RequestBody @NotNull @Valid NewTransactionDto transactionDto,
      @PathVariable("accountId") String accountId) {
    return iTransactionService.addTransaction(transactionDto, accountId);
  }

  @GetMapping("/{accountId}/transactions")
  public Map<String, List<TransactionDto>> getTransactionsByAccount(
      @PathVariable String accountId) {
    return iTransactionService.getTransactionsForAccount(UUID.fromString(accountId));
  }


  @GetMapping("/{accountId}/transactions/filtered")
  public AccountResponseDto findAccountWithTransactionFilter(@RequestParam("min") double minimum,
      @RequestParam("max") double maximum, @PathVariable("accountId") String accountId) {
    return iTransactionService.getFilteredTransactions(UUID.fromString(accountId),
        minimum, maximum);
  }

}
