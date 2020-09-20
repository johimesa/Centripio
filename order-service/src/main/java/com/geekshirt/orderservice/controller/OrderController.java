package com.geekshirt.orderservice.controller;

import com.geekshirt.orderservice.dto.OrderRequest;
import com.geekshirt.orderservice.dto.OrderResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class OrderController {

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
