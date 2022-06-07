package com.hashedin.currencyexchangeservice;


import com.hashedin.currencyexchangeservice.Service.CurrencyExchangeService;
import com.hashedin.currencyexchangeservice.model.CurrencyExchange;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootTest
@ActiveProfiles("dev")
class CurrencyExchangeServiceApplicationTests {
    @Autowired
    public RestTemplate restTemplate;
    @Autowired
    public CurrencyExchangeService currencyExchangeService;

    @Test
    void viewallExchangeRate() {
       List<CurrencyExchange> list= restTemplate.getForObject("http://localhost:8082/exchangerates",List.class);
        Assertions.assertNotNull(list);
    }

    @Test
    void viewallExchangeRateById() {
        CurrencyExchange currencyExchange= currencyExchangeService.getExchangeRateByCurrency("IND");
        Assertions.assertNotNull(currencyExchange);
    }

    @Test
    void addExchangeRate() {
        CurrencyExchange C=new CurrencyExchange();
        C.setCurrency("ABB");
        C.setId(10000L);
        C.setExchangeRate(89.07);
        CurrencyExchange currencyExchange= currencyExchangeService.addExchangeRate(C);
        Assertions.assertNotNull(currencyExchange);
        Assertions.assertTrue(currencyExchange.getCurrency().equals("ABB"));
    }
    /*@Test
    void updateExchangeRate() {
        CurrencyExchange C=new CurrencyExchange();
        C.setCurrency("ABB");
        C.setExchangeRate(89.07);
        currencyExchangeService.updateExchangeRate(4L,C);
        Assertions.assertTrue(currencyExchangeService.getExchangeRateByCurrency("ABB").getExchangeRate()==89.07);
    }*/
    @Test
    void deleteExchangeRate() {
        currencyExchangeService.deleteExchangeRate("AUD");
        Assertions.assertNull(currencyExchangeService.getExchangeRateByCurrency("AUD"));
    }

    @Test
    void loadbyimport() {
        RestTemplate restTemplate=new RestTemplate();
        String s=restTemplate.getForObject("http://localhost:8082/load",String.class);
        Assertions.assertTrue(currencyExchangeService.getAllExchangeRates().size()>0);
    }


}