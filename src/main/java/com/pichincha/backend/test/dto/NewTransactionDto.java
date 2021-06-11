package com.pichincha.backend.test.dto;

import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewTransactionDto {

  private UUID accountId;

  private String type;

  private String comment;

  private int amount;
}
