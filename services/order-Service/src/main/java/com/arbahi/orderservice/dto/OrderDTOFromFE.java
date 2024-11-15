package com.arbahi.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTOFromFE {
    private Integer id;
    private List<FoodItemDTO> foodItems;
    private RestaurantDTO restaurant;
    private Integer userId;
}
