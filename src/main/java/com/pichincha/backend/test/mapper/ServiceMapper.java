package com.pichincha.backend.test.mapper;

import com.pichincha.backend.test.dto.AccountDto;
import com.pichincha.backend.test.dto.AccountResponseDto;
import com.pichincha.backend.test.dto.TransactionDto;
import com.pichincha.backend.test.dto.rest.RestTransaction;
import com.pichincha.backend.test.model.Account;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class ServiceMapper {

  //todo: design a mapper using functions where is able to
  public AccountResponseDto mapResponse() {
    return null;
  }

  public AccountDto toAccountDto(Account account) {
    return new AccountDto(account.getNumber(), account.getType(),
        account.getCreationDate());
  }

  public List<TransactionDto> toTransactionDtoList(List<RestTransaction> transactions) {
    return transactions.stream().map(transaction -> TransactionDto.builder()
        .amount(transaction.getAmount())
        .creationDate(transaction.getCreationDate())
        .type(transaction.getType())
        .build()).collect(Collectors.toList());
  }
}
