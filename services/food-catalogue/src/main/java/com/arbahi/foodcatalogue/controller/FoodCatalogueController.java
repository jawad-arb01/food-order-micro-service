package com.arbahi.foodcatalogue.controller;

import com.arbahi.foodcatalogue.dto.FoodCataloguePage;
import com.arbahi.foodcatalogue.dto.FoodItemDTO;
import com.arbahi.foodcatalogue.service.FoodCatalogueService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/foodCatalogue")
public class FoodCatalogueController {

    private final FoodCatalogueService foodCatalogueService;

    @PostMapping("/addFoodItem")
    public ResponseEntity<FoodItemDTO> addFoodItem(@RequestBody FoodItemDTO foodItemDTO){
        FoodItemDTO foodItemSaved = foodCatalogueService.addFoodItem(foodItemDTO);
        return new ResponseEntity<>(foodItemSaved, HttpStatus.CREATED);
    }

    @GetMapping("/fetchRestaurantAndFoodItemsById/{restaurantId}")
    public ResponseEntity<FoodCataloguePage> fetchRestauDetailsWithFoodMenu(@PathVariable Integer restaurantId){
        FoodCataloguePage foodCataloguePage = foodCatalogueService.fetchFoodCataloguePageDetails(restaurantId);
        return new ResponseEntity<>(foodCataloguePage, HttpStatus.OK);


    }
}
