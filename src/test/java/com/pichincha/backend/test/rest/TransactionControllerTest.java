package com.pichincha.backend.test.rest;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.pichincha.backend.test.dto.NewTransactionDto;
import com.pichincha.backend.test.dto.TransactionDto;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

class TransactionControllerTest extends AbstractControllerTest {


  @Test
  void shouldReturnFoundTransactions() throws Exception {

    // given
    Map<String, List<TransactionDto>> transactions = new HashMap<>();
//    List<TransactionDto> transactions = new ArrayList<>();
    LocalDateTime creationDate = LocalDateTime.of(2018, 5, 20, 20, 51, 16);
    transactions.put("CreditCardPayment", List.of(TransactionDto.builder()
        .id(UUID.randomUUID())
        .comment("July payment")
        .creationDate(creationDate)
        .amount(100)
        .build()));

    // when
    when(transactionService.getTransactionsForAccount(UUID.randomUUID())).thenReturn(transactions);

    // then
    mockMvc.perform(get("/accounts/1/transactions").accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$", hasSize(1)))
        .andExpect(jsonPath("$[0].id", is(2)))
        .andExpect(jsonPath("$[0].comment", is("July payment")))
        .andExpect(jsonPath("$[0].type", is("Credit card payment")))
        .andExpect(jsonPath("$[0].creationDate", is(creationDate.toString())));
  }

  @Test
  void shouldAddTransaction() throws Exception {

    // given
    String transactionBody = "{\"comment\":\"Test comment\", \"type\":\"Credit card payment\"}";
    NewTransactionDto newTransaction = createTransaction("Test comment", "Credit card payment");

    // when
    when(transactionService.addTransaction(newTransaction, UUID.randomUUID().toString()))
        .thenReturn(UUID.randomUUID());

    // then
    mockMvc.perform(post("/accounts/1/transactions")
        .content(transactionBody)
        .contentType(APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isCreated());
  }

  private NewTransactionDto createTransaction(String comment, String type) {
    NewTransactionDto newTransaction = new NewTransactionDto();
    newTransaction.setComment(comment);
    newTransaction.setType(type);
    return newTransaction;
  }


}
