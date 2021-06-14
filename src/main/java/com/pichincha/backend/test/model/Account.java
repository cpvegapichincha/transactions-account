package com.pichincha.backend.test.model;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.GenerationType.AUTO;
import static lombok.AccessLevel.PRIVATE;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "account", schema = "public")
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
//todo: map relation of account with transaction based on migration
public class Account {

  @Id
  @GeneratedValue(strategy = AUTO)
  UUID id;
  String number;
  @Column(length = 70)
  String type;
  @Column(name = "creation_date", insertable = false, updatable = false)
  LocalDateTime creationDate;

  @OneToMany(mappedBy = "account", cascade = ALL)
  List<Transaction> transactions;
}
