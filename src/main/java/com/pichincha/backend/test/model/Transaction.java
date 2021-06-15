package com.pichincha.backend.test.model;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.GenerationType.AUTO;
import static lombok.AccessLevel.PRIVATE;

import java.time.LocalDateTime;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "transaction", schema = "public")
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
public class Transaction {

  @Id
  @GeneratedValue(strategy = AUTO)
  UUID id;
  double amount;
  String type;
  String comment;
  @Column(name = "creation_date",insertable = false,updatable = false)
  LocalDateTime creationDate;
  @ManyToOne(cascade = ALL)
  @JoinColumn(name = "account_id")
  Account account;
}
