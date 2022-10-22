package com.belajar.springboot.service;

import com.belajar.springboot.model.CarImage;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CarImageService {
    CarImage create(int carId, MultipartFile multipartFile) throws Exception;
    List<CarImage> findAll();
}
