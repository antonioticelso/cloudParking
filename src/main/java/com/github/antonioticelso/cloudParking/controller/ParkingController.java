package com.github.antonioticelso.cloudParking.controller;

import com.github.antonioticelso.cloudParking.model.Parking;
import com.github.antonioticelso.cloudParking.model.dto.ParkingCreateDTO;
import com.github.antonioticelso.cloudParking.model.dto.ParkingDTO;
import com.github.antonioticelso.cloudParking.model.mapper.ParkingMapper;
import com.github.antonioticelso.cloudParking.service.ParkingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
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
    public ResponseEntity<List<ParkingDTO>> findAll() {

        List<Parking> parkingList = service.findAll();
        List<ParkingDTO> result = parkingMapper.toParkingDTOList(parkingList);

        return ResponseEntity.ok(result);

    }

    @GetMapping("/{id}")
    public ResponseEntity<ParkingDTO> findById(@PathVariable String id) {

        Parking parking = service.findById(id);
        ParkingDTO result = parkingMapper.toParkingDTO(parking);

        return ResponseEntity.ok(result);

    }

    @PostMapping
    public ResponseEntity<ParkingDTO> create(@RequestBody ParkingCreateDTO dto) {

        Parking parkingCreate = parkingMapper.toParkingCreate(dto);
        Parking parking = service.create(parkingCreate);
        ParkingDTO result = parkingMapper.toParkingDTO(parking);

        return ResponseEntity.status(HttpStatus.CREATED).body(result);

    }

}
