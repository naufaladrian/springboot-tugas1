package com.belajar.springboot.service;

import com.belajar.springboot.model.Car;

import java.util.List;
import java.util.Map;

public interface CarService {
    Car addCar(Car car);
    Car getById(Integer id);
    Car updateCar(Integer id, Car car);
    List<Car> getAllCar();
    Map<String, Boolean> deleteCar(Integer id);
}
