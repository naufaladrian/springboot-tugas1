package com.belajar.springboot.service;

import com.belajar.springboot.model.CarImage;
import com.belajar.springboot.repository.CarImageRepository;
import com.belajar.springboot.repository.CarRepository;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class CarImageServiceImpl implements CarImageService{

    @Autowired
    private CarImageRepository carImageRepository;

    @Autowired
    private CarRepository carRepository;

    @Override
    public CarImage create(int carId, MultipartFile multipartFile) throws Exception {
        CarImage create= new CarImage();
        create.setCarId(carRepository.findById(carId).get());
        create.setImageUrl(convertToBase64(multipartFile));
        return carImageRepository.save(create);
    }

    private String convertToBase64(MultipartFile file) throws Exception {
        try {
            byte[] image = Base64.encodeBase64(file.getBytes());
            String result = new String(image);
            return "data:"+file.getContentType()+";base64,"+result;
        }catch (Exception e){
            throw new Exception(e);
        }
    }
    @Override
    public List<CarImage> findAll() {
        return null;
    }
}
