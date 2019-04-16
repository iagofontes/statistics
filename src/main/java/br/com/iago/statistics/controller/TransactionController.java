package br.com.iago.statistics.controller;

import br.com.iago.statistics.model.Transaction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Calendar;

@Controller
public class TransactionController {

    public static final int SECONDS_LIMIT = 60000;

    @RequestMapping(value = "/transaction", method = RequestMethod.POST)
    public ResponseEntity<Void> createTransaction(@Valid @NotNull @RequestBody Transaction transaction){
        if((System.currentTimeMillis() - transaction.getTimestamp()) > SECONDS_LIMIT) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }

}
