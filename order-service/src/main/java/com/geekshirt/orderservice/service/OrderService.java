package com.geekshirt.orderservice.service;

import com.geekshirt.orderservice.dto.OrderRequest;
import com.geekshirt.orderservice.dto.OrderResponse;
import com.geekshirt.orderservice.entities.Order;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderService {

    public Order createOrder(OrderRequest orderRequest) {

        Order order1 = new Order();
        order1.setAccountId(orderRequest.getAccountId());
        order1.setOrderId("999999");
        order1.setStatus("PENDING");
        order1.setTotalAmount(100.0);
        order1.setTotalTax(10.0);
        order1.setTrxDate(new Date());

        return order1;
    }

    public List<Order> finAllOrders() {
        List<Order> list = new ArrayList<>();

        Order order1 = new Order();
        order1.setAccountId("12345678900");
        order1.setOrderId("111222");
        order1.setStatus("PENDING");
        order1.setTotalAmount(100.0);
        order1.setTotalTax(10.0);
        order1.setTrxDate(new Date());
        list.add(order1);

        order1 = new Order();
        order1.setAccountId("12345678901");
        order1.setOrderId("111333");
        order1.setStatus("PENDING");
        order1.setTotalAmount(120.0);
        order1.setTotalTax(12.0);
        order1.setTrxDate(new Date());
        list.add(order1);

        return list;
    }

    public Order findById(String orderId) {
        Order order1 = new Order();
        order1.setAccountId("12345678900");
        order1.setOrderId(orderId);
        order1.setStatus("PENDING");
        order1.setTotalAmount(100.0);
        order1.setTotalTax(10.0);
        order1.setTrxDate(new Date());

        return order1;
    }
}
