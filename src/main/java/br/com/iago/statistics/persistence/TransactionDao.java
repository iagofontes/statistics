package br.com.iago.statistics.persistence;

import br.com.iago.statistics.model.Transaction;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class TransactionDao {

    public ArrayList<Transaction> transactions = new ArrayList<>();

    public void addTransaction(Transaction transaction) {
        this.transactions.add(transaction);
    }

}
