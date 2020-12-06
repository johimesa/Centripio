package com.geekshirt.orderservice.controller;

import com.geekshirt.orderservice.dto.OrderRequest;
import com.geekshirt.orderservice.dto.OrderResponse;
import com.geekshirt.orderservice.entities.Order;
import com.geekshirt.orderservice.service.OrderService;
import com.geekshirt.orderservice.util.EntityDtoConverter;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Api
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private EntityDtoConverter entityDtoConverter;

    @ApiOperation(value = "Retrieve all existed orders", notes = "This operation returns all orders")
    @GetMapping(value = "order")
    public ResponseEntity<List<OrderResponse>> findAll() {

        List<Order> list = orderService.finAllOrders();
        return new ResponseEntity<>(entityDtoConverter.convertEntityToDto(list), HttpStatus.OK);
    }

    @ApiOperation(value = "Retrieve an order based on ID", notes = "This operation returns an order using it ID")
    @GetMapping(value = "order/{orderId}")
    public ResponseEntity<OrderResponse> findById(@PathVariable String orderId) {

        Order order = orderService.findById(orderId);
        return new ResponseEntity<>(entityDtoConverter.convertEntityToDto(order), HttpStatus.OK);
    }

    @ApiOperation(value = "Creates an Order", notes = "This operation creates a new order")
    @PostMapping(value = "order/create")
    public ResponseEntity<OrderResponse> createOrder(@RequestBody OrderRequest request) {

        Order order = orderService.createOrder(request);
        return new ResponseEntity<>(entityDtoConverter.convertEntityToDto(order), HttpStatus.CREATED);
    }
}
