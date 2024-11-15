package com.arbahi.restaurantlisting.service;

import com.arbahi.restaurantlisting.dto.RestaurantDTO;
import com.arbahi.restaurantlisting.mapper.RestaurantMapper;
import com.arbahi.restaurantlisting.repository.RestaurantRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

@Service
@RequiredArgsConstructor
public class RestaurantService {
    private final RestaurantRepo restaurantRepo;

    public List<RestaurantDTO> findAllRestaurants() {
        return  restaurantRepo
                .findAll()
                .stream()
                .map(restaurant ->
                        RestaurantMapper.INSTANCE.toDto(restaurant))
                .collect(Collectors.toList());
    }

    public RestaurantDTO findRestaurantById(Integer id) {
        return RestaurantMapper.INSTANCE
                .toDto(restaurantRepo
                        .findById(id)
                        .orElse(null));
    }

    public RestaurantDTO addRestaurant(RestaurantDTO restaurantDTO) {
        return RestaurantMapper.INSTANCE
                .toDto(restaurantRepo
                        .save(RestaurantMapper.INSTANCE
                                .toEntity(restaurantDTO)));
    }
}
