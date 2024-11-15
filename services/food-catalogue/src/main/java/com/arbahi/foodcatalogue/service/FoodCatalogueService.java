package com.arbahi.foodcatalogue.service;

import com.arbahi.foodcatalogue.dto.FoodCataloguePage;
import com.arbahi.foodcatalogue.dto.FoodItemDTO;
import com.arbahi.foodcatalogue.dto.Restaurant;
import com.arbahi.foodcatalogue.entity.FoodItem;
import com.arbahi.foodcatalogue.mapper.FoodItemMapper;
import com.arbahi.foodcatalogue.repository.FoodCatalogueRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodCatalogueService {

    private final FoodCatalogueRepo foodCatalogueRepo;
    private final RestTemplate restTemplate;

    public FoodItemDTO addFoodItem(FoodItemDTO foodItemDTO) {
        return FoodItemMapper.INSTANCE
                .toDto(foodCatalogueRepo
                        .save(FoodItemMapper.INSTANCE
                                .toEntity(foodItemDTO)));
    }

    public FoodCataloguePage fetchFoodCataloguePageDetails(Integer restaurantId) {
        Restaurant restaurant = fetchRestaurantDetailsById(restaurantId);
        List<FoodItemDTO> foodItems = fetchFoodCatalogueByRestaurantId(restaurantId);
        FoodCataloguePage foodCataloguePage = combineToFoodCataloguePage(foodItems,restaurant);
        return foodCataloguePage;
    }

    private FoodCataloguePage combineToFoodCataloguePage(List<FoodItemDTO> foodItems, Restaurant restaurant) {
        return FoodCataloguePage.builder()
                .restaurant(restaurant)
                .foodItemsList(foodItems.stream().map(FoodItemMapper.INSTANCE::toEntity).toList())
                .build();
    }

    private Restaurant fetchRestaurantDetailsById(Integer restaurantId) {
        return restTemplate.getForObject("http://RESTAURANT-SERVICE/restaurant/fetchRestaurantById/"+restaurantId, Restaurant.class);
    }

    private List<FoodItemDTO> fetchFoodCatalogueByRestaurantId(Integer restaurantId) {
        return foodCatalogueRepo.findByRestaurantId(restaurantId).stream()
                .map(FoodItemMapper.INSTANCE::toDto)
                .toList();
    }


}
