package com.halyson.cardapio.controller;

import com.halyson.cardapio.food.Food;
import com.halyson.cardapio.food.FoodRepository;
import com.halyson.cardapio.food.FoodRequestDTD;
import com.halyson.cardapio.food.FoodResponseDTD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("food")
public class FoodController {

    @Autowired
    private FoodRepository repository;

    @CrossOrigin(origins ="*", allowedHeaders ="*")
    @PostMapping
    public void saveFood(@RequestBody FoodRequestDTD data){
        Food foodData = new Food(data);
        repository.save(foodData);
        return;
    }

    @GetMapping
    public List<FoodResponseDTD> getAll(){

        List<FoodResponseDTD> foodList = repository.findAll().stream().map(FoodResponseDTD::new).toList();
        return foodList;
    }

}
