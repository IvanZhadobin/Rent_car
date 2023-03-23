package org.example;

import bl.Util;
import entity.Car;
import service.CarService;

import java.sql.SQLException;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        Util util = new Util();
        util.getConnection();
        Car car = new Car(50L, "BMW", LocalDate.of(2020, 4, 17), 23, "C", 300, 2L);
        CarService carService = new CarService();
        try {
            carService.update(car);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}