package com.pichincha.backend.test.mapper;

import static com.pichincha.backend.test.Constants.ACCOUNT_NOT_FOUND;

import com.pichincha.backend.test.dto.AccountDto;
import com.pichincha.backend.test.dto.AccountResponseDto;
import com.pichincha.backend.test.dto.NewTransactionDto;
import com.pichincha.backend.test.dto.TransactionDto;
import com.pichincha.backend.test.dto.TransactionResponseDto;
import com.pichincha.backend.test.dto.rest.RestTransaction;
import com.pichincha.backend.test.exception.AccountNotFoundException;
import com.pichincha.backend.test.model.Account;
import com.pichincha.backend.test.model.Transaction;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class ServiceMapper {

  //todo: design a mapper using functions where is able to
  public AccountResponseDto mapResponse(List<Transaction> transactions)
      throws AccountNotFoundException {
    AccountResponseDto.AccountResponseDtoBuilder builder = AccountResponseDto.builder();
    builder.account(transactions.stream().findFirst()
        .orElseThrow(() -> new AccountNotFoundException(ACCOUNT_NOT_FOUND))
        .getAccount().getNumber());
    builder.transactions(transactions.stream().map(this::toTransactionResponseDto).
        collect(Collectors.toList()));
    return builder.build();
  }

  private TransactionResponseDto toTransactionResponseDto(Transaction transaction) {
    return TransactionResponseDto.builder()
        .amount(transaction.getAmount())
        .type(transaction.getType())
        .build();
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

  public List<TransactionDto> toTransactionDtoListFromDatabase(List<Transaction> transactions) {
    return transactions.stream().map(transaction -> TransactionDto.builder()
        .type(String.valueOf(transaction.getType()))
        .creationDate(transaction.getCreationDate())
        .comment(transaction.getComment())
        .amount(transaction.getAmount())
        .build()).collect(Collectors.toList());
  }

  public Transaction toTransaction(NewTransactionDto newTransactionDto, Account account) {
    return Transaction.builder()
        .account(account)
        .amount(newTransactionDto.getAmount())
        .comment(newTransactionDto.getComment())
        .type(newTransactionDto.getType())
        .build();
  }
}
