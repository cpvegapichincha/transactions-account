package com.pichincha.backend.test.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewTransactionDto {

  @NotEmpty
  private String type;

  @NotEmpty
  private String comment;

  @Min(1)
  private double amount;
}
