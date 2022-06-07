package com.hashedin.currencyexchangeservice.Service;

import com.hashedin.currencyexchangeservice.Repository.CurrencyExchangeRepository;
import com.hashedin.currencyexchangeservice.model.CurrencyExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CurrencyExchangeService {
    @Autowired
    public CurrencyExchangeRepository currencyExchangeRepository;

    public List<CurrencyExchange> getAllExchangeRates(){
        return currencyExchangeRepository.findAll();
    }

    public CurrencyExchange getExchangeRateByCurrency(String currency){
        for(CurrencyExchange i:currencyExchangeRepository.findAll()){
            if(i.getCurrency().equals(currency)){
                return i;
            }

        }
       return null;
    }

    public double findExchangeRate(String curr){
        for(CurrencyExchange i:currencyExchangeRepository.findAll()){
            if(i.getCurrency().equals(curr)){
                return i.getExchangeRate();
            }
        }
        return 0.0;
    }
    public CurrencyExchange addExchangeRate(CurrencyExchange currency){
        return (currencyExchangeRepository.save(currency));
    }

    public void updateExchangeRate(Long id,CurrencyExchange currency){

        CurrencyExchange c=new CurrencyExchange();
        c=currencyExchangeRepository.findById(id).get();
        c.setCurrency(currency.getCurrency());
        c.setExchangeRate(currency.getExchangeRate());
        currencyExchangeRepository.save(c);
    }

    public void deleteExchangeRate(String currency){
        for(CurrencyExchange i:currencyExchangeRepository.findAll()){
            if(i.getCurrency().equals(currency)){
                currencyExchangeRepository.deleteById(i.getId());

            }

        }

    }

}
