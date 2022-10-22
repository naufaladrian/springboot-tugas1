package com.belajar.springboot.model;

import javax.persistence.*;

@Entity
@Table(name= "car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "car_name", nullable = false, unique = true)
    private String carName;

    @Column(name = "type")
    private String type;

    @Column(name = "number")
    private String number;

    @Column(name = "color")
    private String color;

    public Car(int id, String carName, String type, String number, String color) {
        this.id = id;
        this.carName = carName;
        this.type = type;
        this.number = number;
        this.color = color;
    }

    public Car() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "car{" +
                "id=" + id +
                ", carName='" + carName + '\'' +
                ", type='" + type + '\'' +
                ", number='" + number + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
