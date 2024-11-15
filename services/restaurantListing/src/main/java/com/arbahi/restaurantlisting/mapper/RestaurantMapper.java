package com.arbahi.restaurantlisting.mapper;

import com.arbahi.restaurantlisting.dto.RestaurantDTO;
import com.arbahi.restaurantlisting.entity.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RestaurantMapper {

    RestaurantMapper INSTANCE = Mappers.getMapper(RestaurantMapper.class);

    Restaurant toEntity(RestaurantDTO dto);
    RestaurantDTO toDto(Restaurant entity);

}
