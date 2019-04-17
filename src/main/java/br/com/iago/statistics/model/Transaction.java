package br.com.iago.statistics.model;

import br.com.iago.statistics.controller.TransactionController;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@EqualsAndHashCode
public class Transaction {

    private Long id;

    @NotNull
    private Double amount;

    @NotNull
    private Long timestamp;

    @JsonIgnore
    public boolean dentroDoLimite() {
        return System.currentTimeMillis() - timestamp <= TransactionController.SECONDS_LIMIT;
    }

}
