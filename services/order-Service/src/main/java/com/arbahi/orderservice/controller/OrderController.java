package com.arbahi.orderservice.controller;

import com.arbahi.orderservice.dto.OrderDTO;
import com.arbahi.orderservice.dto.OrderDTOFromFE;
import com.arbahi.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/saveOrder")
    public ResponseEntity<OrderDTO> saveOrder(@RequestBody OrderDTOFromFE orderDetails) {
        return new ResponseEntity<>(orderService.saveOrder(orderDetails), HttpStatus.CREATED);
    }
}
