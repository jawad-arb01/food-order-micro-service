package com.arbahi.orderservice.service;

import com.arbahi.orderservice.dto.OrderDTO;
import com.arbahi.orderservice.dto.OrderDTOFromFE;
import com.arbahi.orderservice.dto.UserDTO;
import com.arbahi.orderservice.entity.Order;
import com.arbahi.orderservice.mapper.OrderMapper;
import com.arbahi.orderservice.repository.OrderRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepo orderRepo;
    private final SequenceGenerator sequenceGenerator;
    private final RestTemplate restTemplate;

    public OrderDTO saveOrder(OrderDTOFromFE orderDetails) {
        Order order = Order.builder()
                .id(sequenceGenerator.generateNextOrderId())
                .foodItems(orderDetails.getFoodItems())
                .restaurant(orderDetails.getRestaurant())
                .user(restTemplate.getForObject("http://USER-SERVICE/user/fetchUserById/"+orderDetails.getUserId(), UserDTO.class))
                .build();
        return OrderMapper.INSTANCE.toDTO(orderRepo.save(order));
    }
}
