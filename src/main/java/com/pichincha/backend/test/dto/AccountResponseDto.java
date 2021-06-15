package com.pichincha.backend.test.dto;

import static lombok.AccessLevel.PRIVATE;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

//todo: if you know lombok, use annotations if not use traditional way or implement anything you know besides this 2
//todo: modify anything you need here to fulfill the requirements of the exercise
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = PRIVATE)
public class AccountResponseDto {

  String account;
  List<TransactionResponseDto> transactions;

}
