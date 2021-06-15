package com.pichincha.backend.test.rest;

import static org.mockito.Mockito.reset;

import com.pichincha.backend.test.service.AccountService;
import com.pichincha.backend.test.service.TransactionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(SpringExtension.class)
@WebMvcTest
public abstract class AbstractControllerTest {

  @Autowired
  protected MockMvc mockMvc;

  @MockBean
  protected TransactionService transactionService;

  @MockBean
  protected AccountService accountService;

  @BeforeEach
  public void setUp() {
    reset(transactionService);
    reset(accountService);
  }

}
