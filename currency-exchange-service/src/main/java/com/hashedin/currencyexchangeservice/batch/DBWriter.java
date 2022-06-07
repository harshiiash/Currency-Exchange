package com.hashedin.currencyexchangeservice.batch;
import com.hashedin.currencyexchangeservice.Repository.CurrencyExchangeRepository;
import com.hashedin.currencyexchangeservice.model.CurrencyExchange;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DBWriter implements ItemWriter<CurrencyExchange> {

    private CurrencyExchangeRepository currencyExchangeRepository;

    @Autowired
    public DBWriter (CurrencyExchangeRepository currencyExchangeRepository) {
        this.currencyExchangeRepository = currencyExchangeRepository;
    }

    @Override
    public void write(List<? extends CurrencyExchange> currencyExchanges) throws Exception{
        System.out.println("Data Saved " );
        currencyExchangeRepository.saveAll(currencyExchanges);
    }
}