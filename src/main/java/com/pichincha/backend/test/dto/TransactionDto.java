package com.pichincha.backend.test.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class TransactionDto {

  private final Long id;

  private final String comment;

  private final String type;

  private final LocalDateTime creationDate;

  private final int amount;

}
