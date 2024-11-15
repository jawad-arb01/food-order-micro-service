package com.arbahi.foodcatalogue.mapper;

import com.arbahi.foodcatalogue.dto.FoodItemDTO;
import com.arbahi.foodcatalogue.entity.FoodItem;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FoodItemMapper {
    FoodItemMapper INSTANCE = Mappers.getMapper(FoodItemMapper.class);

    FoodItemDTO toDto(FoodItem foodItem);
    FoodItem toEntity(FoodItemDTO foodItemDTO);
}
