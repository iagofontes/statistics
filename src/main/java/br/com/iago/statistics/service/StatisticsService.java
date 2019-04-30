package br.com.iago.statistics.service;

import br.com.iago.statistics.comparator.TransactionTimestampComparator;
import br.com.iago.statistics.dto.Statistics;
import br.com.iago.statistics.model.Transaction;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.Getter;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.concurrent.PriorityBlockingQueue;

@Service
public class StatisticsService {

    private static final int INTERVALO_ATUALIZACAO_MILISSEG =  10000;
    private static final int CAPACIDADE_LISTA =  100;

    private final PriorityBlockingQueue<Transaction> ultimasTransacoes =
            new PriorityBlockingQueue<>(CAPACIDADE_LISTA, new TransactionTimestampComparator());

    @Getter
    private Statistics statistics = new Statistics(ultimasTransacoes);

    @Scheduled(fixedDelay = INTERVALO_ATUALIZACAO_MILISSEG)
    public void limparTransacoesAntigas() {
//        remove da lista as transações com mais de 60 segundos
        while (!ultimasTransacoes.isEmpty() && !ultimasTransacoes.peek().dentroDoLimite()) {
            ultimasTransacoes.poll();
        }
        updateStatistics();
    }

    public void adicionarTransacao(Transaction transaction) {
        ultimasTransacoes.add(transaction);
        updateStatistics();
    }

    private void updateStatistics() {
        statistics = new Statistics(ultimasTransacoes);
    }

}
