package com.hashedin.apigatewayserver.Model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "Currency Convertor")
public class CurrencyConvertor {

    @ApiModelProperty(value = "id", dataType = "Long")
    private Long id;
    @ApiModelProperty(value = "Storing currency from which amount is to be converted", dataType = "String")
    private String from;
    @ApiModelProperty(value = "Storing currency in which amount is to be converted", dataType = "String")
    private String to;
    @ApiModelProperty(value = "Exchange rate for conversion", dataType = "String")
    private String exchangeRate;
    @ApiModelProperty(value = "Storing amount to be converted", dataType = "Integer")
    private int quantity;
    @ApiModelProperty(value = "Stores the converted amount", dataType = "String")
    private String convertedAmount;


}
