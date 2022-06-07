package com.hashedin.apigatewayserver;

import com.hashedin.apigatewayserver.Model.CurrencyConvertor;
import com.hashedin.apigatewayserver.Model.CurrencyExchange;
import com.hashedin.apigatewayserver.feign.ConversionFeignClient;
import com.hashedin.apigatewayserver.feign.ExchangeFeignClent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootTest
@ActiveProfiles("dev")
class ApiGatewayServerApplicationTests {

	@Autowired
	public ExchangeFeignClent exchangeFeignClent;

	@Autowired
	public ConversionFeignClient conversionFeignClient;

	@Test
	void getAllexchangerate() {

		List<CurrencyExchange> list= exchangeFeignClent.viewCurrentExchange();
		Assertions.assertNotNull(list);
	}
	@Test
	void viewallExchangeRateById() {
		double currencyExchange= exchangeFeignClent.findCurrentExchange("IND");
		Assertions.assertNotNull(currencyExchange);
	}

	@Test
	void addExchangeRate() {
		CurrencyExchange C=new CurrencyExchange();
		C.setCurrency("ABB");
		C.setId(10000L);
		C.setExchangeRate(89.07);
		CurrencyExchange currencyExchange= exchangeFeignClent.addExchangeRate(C);
		Assertions.assertNotNull(currencyExchange);
		Assertions.assertTrue(currencyExchange.getCurrency().equals("ABB"));
	}

	@Test
	void deleteExchangeRate() {
		exchangeFeignClent.deleteExchangeRate("AUD");
		Assertions.assertNotNull(exchangeFeignClent.findCurrentExchange("AUD"));
	}

	@Test
	void loadbyimport() {
		RestTemplate restTemplate=new RestTemplate();
		String s=restTemplate.getForObject("http://localhost:8082/load",String.class);
		Assertions.assertTrue(exchangeFeignClent.viewCurrentExchange().size()>0);
	}

	@Test
	public void checkConversion(){
		String s =conversionFeignClient.convertCurrency("IND","AUD",10);
		Assertions.assertNotNull(s);

	}





}
