package com.belajar.springboot.controller;

import com.belajar.springboot.model.CarImage;
import com.belajar.springboot.service.CarImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/carImage")
public class CarImageController {
    @Autowired
    private CarImageService carImageService;

    @PostMapping(consumes = "multipart/form-data")
    public CarImage addCarImage(@RequestPart("id") String id, @RequestPart("file")MultipartFile multipartFile) throws Exception {
        return carImageService.create(Integer.valueOf(id), multipartFile);
    }
}
