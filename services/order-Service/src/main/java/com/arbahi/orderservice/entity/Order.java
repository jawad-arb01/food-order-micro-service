package com.arbahi.orderservice.entity;


import com.arbahi.orderservice.dto.FoodItemDTO;
import com.arbahi.orderservice.dto.RestaurantDTO;
import com.arbahi.orderservice.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document("order")
public class Order {
    private Integer id;
    private List<FoodItemDTO> foodItems;
    private RestaurantDTO restaurant;
    private UserDTO user;
}
