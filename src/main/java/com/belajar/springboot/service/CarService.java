package com.belajar.springboot.service;

import com.belajar.springboot.model.Car;

import java.util.List;
import java.util.Map;

public interface CarService {
    Car addCar(Car car);
    Car getById(Long id);
    Car updateCar(Long id, Car car);
    List<Car> getAllCar();
    Map<String, Boolean> deleteCar(Long id);
}
