package com.geekshirt.orderservice.controller;

import com.geekshirt.orderservice.dto.OrderRequest;
import com.geekshirt.orderservice.dto.OrderResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Api
@RestController
public class OrderController {

    @ApiOperation(value = "Retrieve all existed orders", notes = "This operation returns all orders")
    @GetMapping(value = "order")
    public ResponseEntity<List<OrderResponse>> findAll() {
        List<OrderResponse> list = new ArrayList<>();

        OrderResponse order1 = new OrderResponse();
        order1.setAccountId("12345678900");
        order1.setOrderId("111222");
        order1.setStatus("PENDING");
        order1.setTotalAmount(100.0);
        order1.setTotalTax(10.0);
        order1.setTrxDate(new Date());
        list.add(order1);

        order1 = new OrderResponse();
        order1.setAccountId("12345678901");
        order1.setOrderId("111333");
        order1.setStatus("PENDING");
        order1.setTotalAmount(120.0);
        order1.setTotalTax(12.0);
        order1.setTrxDate(new Date());
        list.add(order1);

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @ApiOperation(value = "Retrieve an order based on ID", notes = "This operation returns an order using it ID")
    @GetMapping(value = "order/{orderId}")
    public ResponseEntity<OrderResponse> findById(@PathVariable String orderId) {
        OrderResponse order1 = new OrderResponse();
        order1.setAccountId("12345678900");
        order1.setOrderId(orderId);
        order1.setStatus("PENDING");
        order1.setTotalAmount(100.0);
        order1.setTotalTax(10.0);
        order1.setTrxDate(new Date());

        return new ResponseEntity<>(order1, HttpStatus.OK);
    }

    @ApiOperation(value = "Creates an Order", notes = "This operation creates a new order")
    @PostMapping(value = "order/create")
    public ResponseEntity<OrderResponse> createOrder(@RequestBody OrderRequest request) {
        OrderResponse order1 = new OrderResponse();
        order1.setAccountId(request.getAccountId());
        order1.setOrderId("999999");
        order1.setStatus("PENDING");
        order1.setTotalAmount(100.0);
        order1.setTotalTax(10.0);
        order1.setTrxDate(new Date());

        return new ResponseEntity<>(order1, HttpStatus.CREATED);
    }
}
