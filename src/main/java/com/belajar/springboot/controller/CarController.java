package com.belajar.springboot.controller;

import com.belajar.springboot.model.Car;
import com.belajar.springboot.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/car")
public class CarController {
    @Autowired
    private CarService carService;

    @PostMapping
    public Car addCar(@RequestBody Car car){
        return carService.addCar(car);
    }
    @GetMapping("/{id}")
    public Car findById(@PathVariable("id") Integer id){
        return carService.getById(id);
    }
    @GetMapping
    public List<Car> getAll(){
        return carService.getAllCar();
    }
    @PutMapping("/{id}")
    public Car updateCar(@PathVariable("id")Integer id, @RequestBody Car car){
        return carService.updateCar(id, car);
    }
    @DeleteMapping("/{id}")
    private Map<String, Boolean> deleteCar(@PathVariable("id")Integer id){
        return carService.deleteCar(id);
    }
}
