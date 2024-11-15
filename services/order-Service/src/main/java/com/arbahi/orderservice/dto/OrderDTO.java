package com.arbahi.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDTO {
    private Integer id;
    private List<FoodItemDTO> foodItems;
    private RestaurantDTO restaurant;
    private UserDTO user;
}
