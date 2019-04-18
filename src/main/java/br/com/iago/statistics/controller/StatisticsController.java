package br.com.iago.statistics.controller;

import br.com.iago.statistics.dto.Statistics;
import br.com.iago.statistics.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StatisticsController {

    @Autowired
    private StatisticsService statisticsService;

    @GetMapping("/statistics")
    @ResponseBody
    public ResponseEntity<Statistics> getStatisticsReport() {
        return new ResponseEntity<>(statisticsService.getStatistics(), HttpStatus.OK);
    }

}
