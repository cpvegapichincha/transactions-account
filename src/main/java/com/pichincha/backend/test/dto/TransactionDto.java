package com.pichincha.backend.test.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Builder
@Setter
@NoArgsConstructor
public class TransactionDto {

  private Long id;

  private String comment;

  private String type;

  private LocalDateTime creationDate;

  private double amount;

}
