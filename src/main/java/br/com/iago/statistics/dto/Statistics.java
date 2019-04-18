package br.com.iago.statistics.dto;

import br.com.iago.statistics.model.Transaction;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@EqualsAndHashCode
public class Statistics {

    private Double sum = 0.0;
    private Double avg = 0.0;
    private Double max = 0.0;
    private Double min = 0.0;
    private Long count;

    public Statistics() {}

    public Statistics(Collection<Transaction> transactions) {
        final List<Double> amountsLastMinute = transactions.stream().map(Transaction::getAmount).collect(Collectors.toList());
        this.setCount(amountsLastMinute.stream().count());
        if(this.getCount() > 0) {
            this.setSum(amountsLastMinute.stream().mapToDouble(Double::doubleValue).sum());
            this.setAvg(amountsLastMinute.stream().mapToDouble(Double::doubleValue).average().getAsDouble());
            this.setMax(amountsLastMinute.stream().max(Double::compareTo).get());
            this.setMin(amountsLastMinute.stream().min(Double::compareTo).get());
        }
    }

}
