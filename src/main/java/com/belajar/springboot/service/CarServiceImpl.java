package com.belajar.springboot.service;

import com.belajar.springboot.model.Car;
import com.belajar.springboot.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CarServiceImpl implements CarService{
    @Autowired
    private CarRepository carRepository;

    @Override
    public Car addCar(Car car){
        return carRepository.save(car);
    }

    @Override
    public Car getById(Long id){
        return carRepository.findById(id).get();
    }

    @Override
    public List<Car> getAllCar(){
        return carRepository.findAll();
    }

    @Override
    public Car updateCar(Long id, Car car) {
        Car updateDataCar = carRepository.findById(id).get();
        updateDataCar.setCarName(car.getCarName());
        updateDataCar.setColor(car.getColor());
        updateDataCar.setType(car.getType());
        updateDataCar.setNumber(car.getNumber());
        return carRepository.save(updateDataCar);
    }

    @Override
    public Map<String, Boolean> deleteCar(Long id) {
        Car updateDataCar =carRepository.findById(id).get();
        carRepository.delete(updateDataCar);
        Map<String, Boolean> response =new HashMap<>();
        response.put("DELETED", Boolean.TRUE);
        return response;
    }
}
