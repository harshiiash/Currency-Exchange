package com.hashedin.currencyexchangeservice.Controller;

import com.hashedin.currencyexchangeservice.ExceptionHandling.EntityNotFoundException;
import com.hashedin.currencyexchangeservice.Service.CurrencyExchangeService;
import com.hashedin.currencyexchangeservice.model.CurrencyExchange;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.hibernate.action.internal.EntityActionVetoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@Api(description = "Currency Exchange Service")
public class CurrencyExchangeController {
    @Autowired
    public CurrencyExchangeService currencyExchangeService;

    @Cacheable("getexchangerate")
    @GetMapping("/exchangerates")
    @ApiOperation(value = "View all exchange rates", response = Iterable.class)
    public List<CurrencyExchange> viewCurrentExchange(){
        return currencyExchangeService.getAllExchangeRates();
    }

    @Cacheable("getone")
    @GetMapping("/findexchangerate/{curr}")
    @ApiOperation(value = "Find currency exchange rate", response=Double.class)
    public double findCurrentExchange(@PathVariable String curr) throws EntityNotFoundException {
        return currencyExchangeService.findExchangeRate(curr);
    }

    @PostMapping("/addexchangerate")
    @ApiOperation(value="Add Exchange Rate", response = CurrencyExchange.class)
    public CurrencyExchange addExchangeRate(@RequestBody CurrencyExchange c) {
        return currencyExchangeService.addExchangeRate(c);
    }

    @PutMapping("/updateexchangerate/{id}")
    @ApiOperation(value = "Update Exchange Rate",response = void.class)
    public void updateExchangeRate(@PathVariable long id,@RequestBody CurrencyExchange c) throws EntityNotFoundException{
        currencyExchangeService.updateExchangeRate(id,c);
    }

    @DeleteMapping("/deleteexchangerate/{curr}")
    @ApiOperation(value="Delete Exchange Rate", response = void.class)
    public void deleteExchangeRate(@PathVariable String curr) throws EntityNotFoundException{
        currencyExchangeService.deleteExchangeRate(curr);

    }
}
