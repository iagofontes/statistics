package br.com.iago.statistics.model;

import br.com.iago.statistics.controller.TransactionController;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {

    @NotNull
    private Double amount;

    @NotNull
    private Long timestamp;

    @JsonIgnore
    public boolean dentroDoLimite() {
        return System.currentTimeMillis() - timestamp <= TransactionController.SECONDS_LIMIT;
    }

}
