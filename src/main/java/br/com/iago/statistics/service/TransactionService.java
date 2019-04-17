package br.com.iago.statistics.service;

import br.com.iago.statistics.dto.Statistics;
import br.com.iago.statistics.model.Transaction;
import br.com.iago.statistics.persistence.TransactionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TransactionService {

    @Autowired
    private TransactionDao transactionDao;
    @Autowired
    private StatisticsService statisticsService;

    public void saveTransaction(Transaction transaction) {
        transactionDao.addTransaction(transaction);
        statisticsService.adicionarTransacao(transaction);
    }

}
