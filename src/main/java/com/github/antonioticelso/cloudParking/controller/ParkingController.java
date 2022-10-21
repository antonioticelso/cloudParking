package com.github.antonioticelso.cloudParking.controller;

import com.github.antonioticelso.cloudParking.model.Parking;
import com.github.antonioticelso.cloudParking.model.dto.ParkingDTO;
import com.github.antonioticelso.cloudParking.model.mapper.ParkingMapper;
import com.github.antonioticelso.cloudParking.service.ParkingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/parking")
public class ParkingController {

    private final ParkingService service;
    private final ParkingMapper parkingMapper;

    public ParkingController(ParkingService service, ParkingMapper parkingMapper) {
        this.service = service;
        this.parkingMapper = parkingMapper;
    }

    @GetMapping
    public List<ParkingDTO> findAll() {

        List<Parking> parkingList = service.findAll();
        List<ParkingDTO> result = parkingMapper.toParkingDTOList(parkingList);

        return result;

    }

}
