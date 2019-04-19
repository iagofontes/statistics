package br.com.iago.statistics.controller;

import br.com.iago.statistics.dto.Statistics;
import br.com.iago.statistics.service.StatisticsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Api(value = "Statistics", description = "Estatísticas das transações gravadas")
@Controller
public class StatisticsController {

    @Autowired
    private StatisticsService statisticsService;

    @ApiOperation(value = "Gera o relatório de estatísticas das transações já presentes na base")
    @GetMapping("/statistics")
    @ResponseBody
    public ResponseEntity<Statistics> getStatisticsReport() {
        return new ResponseEntity<>(statisticsService.getStatistics(), HttpStatus.OK);
    }

}
