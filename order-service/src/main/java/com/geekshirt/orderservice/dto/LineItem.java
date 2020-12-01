package com.geekshirt.orderservice.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "Class that represents an included in the order")
public class LineItem {

    @ApiModelProperty(notes = "Universal Product Code, Length 12 digits", example = "123456789123", required = true)
    private String upc;

    @ApiModelProperty(notes = "Quantity", example = "10", required = true)
    private int quantity;

    @ApiModelProperty(notes = "Price", example = "10.00", required = true)
    private double price;
}
