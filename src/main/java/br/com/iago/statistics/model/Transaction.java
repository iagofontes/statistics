package br.com.iago.statistics.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

@Getter
@Setter
@EqualsAndHashCode
public class Transaction {

    private Long id;

    @NotNull
    private Double amount;

    @NotNull
    private long timestamp;


}
