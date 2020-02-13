package com.postgrestest.jsonpostgres.controllers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.postgrestest.jsonpostgres.entity.Stock;
import com.postgrestest.jsonpostgres.repositories.StockRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

@RestController
public class StockController {

    private static final Logger logger = LoggerFactory.getLogger(StockController.class);

    private StockRepository stockRepository;

    @Autowired
    public StockController(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @RequestMapping("stock")
    public void json() {

        URL url = null;
        try {
            url = new URL("https://morningstar1.p.rapidapi.com/endofdayquotes/history?Mic=XNAS&EndOfDayQuoteTicker=126.1.MSFT");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        //File jsonFile = new File(url.getFile());

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            List<Stock> stocks = objectMapper.readValue(url, new TypeReference<List<Stock>>() {
            });
            stockRepository.saveAll(stocks);
        } catch (IOException e) {
            e.printStackTrace();
        }
//        if (jsonFile!=null) {
//            try {
//                List<Stock> stocks = objectMapper.readValue(jsonFile, new TypeReference<List<Stock>>() {
//                });
//                stockRepository.saveAll(stocks);
//                logger.info("Saved");
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        } else
//            logger.warn("Is null");
    }
}
