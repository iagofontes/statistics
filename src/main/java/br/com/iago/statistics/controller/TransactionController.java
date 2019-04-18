package br.com.iago.statistics.controller;

import br.com.iago.statistics.model.Transaction;
import br.com.iago.statistics.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Controller
public class TransactionController {

    public static final int SECONDS_LIMIT = 60000;

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/transaction")
    public ResponseEntity<Void> createTransaction(@Valid @NotNull @RequestBody Transaction transaction){
        if((System.currentTimeMillis() - transaction.getTimestamp()) > SECONDS_LIMIT) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            transactionService.saveTransaction(transaction);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }

}
