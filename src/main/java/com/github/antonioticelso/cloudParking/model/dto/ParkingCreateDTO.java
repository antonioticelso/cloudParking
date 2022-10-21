package com.github.antonioticelso.cloudParking.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ParkingCreateDTO {

    private String license;
    private String state;
    private String model;
    private String color;

}
