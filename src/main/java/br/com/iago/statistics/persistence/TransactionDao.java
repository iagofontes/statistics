package br.com.iago.statistics.persistence;

import br.com.iago.statistics.model.Transaction;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

@Component
public class TransactionDao {

    public Collection<Transaction> transactions = Collections.synchronizedList(new ArrayList<>());

    public void addTransaction(Transaction transaction) {
        this.transactions.add(transaction);
    }

}
