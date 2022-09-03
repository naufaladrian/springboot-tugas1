package com.belajar.springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping
public class CarController {
    @GetMapping
    public String test(){
        Date date=new Date();
        return "Laman ini dibuka pada"+" "+date;
    }
    @GetMapping("/naufal")
    public String helloworld(){
        return "Nama : M Naufal Adrian Pratama Putra <br>" +
                "Alamat : Jatisari, Mijen, Semarang <br>" +
                "Pendidikan Terakhir : SMA";
    }
    @GetMapping("/naufal/bootcamp")
    public String hello(){
        return "tempat kurang strategis";
    }
}
