package com.hashedin.currencyexchangeservice.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ApiModel(description = "Currency Exchange")
public class CurrencyExchange {
    @Id
    @ApiModelProperty(value = "id", dataType = "Long")
    private long id;

    @ApiModelProperty(value = "Currency of the country", dataType = "String")
    private String currency;

    @ApiModelProperty(value = "Exchange Rate of the currency", dataType = "Double")
    private double exchangeRate;

}
