package com.codingshuttle.project.uber.uberApp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DriverDto {

    private Long Id;

    private UserDto user;

    private Double rating;

    private boolean available;

    private String vehicleNumber;
}
