package com.pichincha.backend.test.rest;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.pichincha.backend.test.dto.AccountDto;
import java.time.LocalDateTime;
import java.util.UUID;
import org.junit.jupiter.api.Test;

class AccountControllerTest extends AbstractControllerTest {

  @Test
  void shouldReturnFoundAccount() throws Exception {
    // given
    LocalDateTime creationDate = LocalDateTime.of(2020, 9, 21, 15, 00, 16);
    AccountDto account = new AccountDto("001", "saving", creationDate);

    // when
    when(accountService.getAccount(UUID.randomUUID())).thenReturn(account);

    // then
    mockMvc.perform(get("/accounts/1").accept(APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(content().contentType(APPLICATION_JSON))
        .andExpect(jsonPath("$.number", is("001")))
        .andExpect(jsonPath("$.type", is("saving")))
        .andExpect(jsonPath("$.creationDate", is(creationDate.toString())));
  }
}
