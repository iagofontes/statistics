package br.com.iago.statistics.controller;

import br.com.iago.statistics.exception.OldTransactionException;
import br.com.iago.statistics.model.Transaction;
import br.com.iago.statistics.service.TransactionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Api(value = "Transaction", description = "Transações já realizadas")
@Controller
public class TransactionController {

    public static final int SECONDS_LIMIT = 60000;

    @Autowired
    private TransactionService transactionService;

    @ApiOperation(value = "Realiza a validação e persistência da transação informada no corpo da requisição")
    @PostMapping("/transaction")
    public ResponseEntity<Void> createTransaction(@Valid @NotNull @RequestBody Transaction transaction) throws OldTransactionException {
        if((System.currentTimeMillis() - transaction.getTimestamp()) > SECONDS_LIMIT) {
            throw new OldTransactionException("A transação ocorreu a mais de 60 segundos");
        } else {
            transactionService.saveTransaction(transaction);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }

}
