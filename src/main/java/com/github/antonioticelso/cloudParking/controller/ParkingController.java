package com.github.antonioticelso.cloudParking.controller;

import com.github.antonioticelso.cloudParking.model.Parking;
import com.github.antonioticelso.cloudParking.model.dto.ParkingCreateDTO;
import com.github.antonioticelso.cloudParking.model.dto.ParkingDTO;
import com.github.antonioticelso.cloudParking.model.mapper.ParkingMapper;
import com.github.antonioticelso.cloudParking.service.ParkingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parking")
@Api(tags = "Parking Controller")
public class ParkingController {

    private final ParkingService service;
    private final ParkingMapper parkingMapper;

    public ParkingController(ParkingService service, ParkingMapper parkingMapper) {
        this.service = service;
        this.parkingMapper = parkingMapper;
    }

    @GetMapping
    @ApiOperation("Find all parkings")
    public ResponseEntity<List<ParkingDTO>> findAll() {

        List<Parking> parkingList = service.findAll();
        List<ParkingDTO> result = parkingMapper.toParkingDTOList(parkingList);

        return ResponseEntity.ok(result);

    }

    @GetMapping("/{id}")
    @ApiOperation("Find by parking for id")
    public ResponseEntity<ParkingDTO> findById(@PathVariable String id) {

        Parking parking = service.findById(id);
        ParkingDTO result = parkingMapper.toParkingDTO(parking);

        return ResponseEntity.ok(result);

    }

    @PostMapping
    @ApiOperation("New parkings")
    public ResponseEntity<ParkingDTO> create(@RequestBody ParkingCreateDTO dto) {

        Parking parkingCreate = parkingMapper.toParkingCreate(dto);
        Parking parking = service.create(parkingCreate);
        ParkingDTO result = parkingMapper.toParkingDTO(parking);

        return ResponseEntity.status(HttpStatus.CREATED).body(result);

    }

    @PutMapping("/{id}")
    @ApiOperation("Update parkings")
    public ResponseEntity<ParkingDTO> update(@PathVariable String id, @RequestBody ParkingCreateDTO dto) {

        Parking parkingCreate = parkingMapper.toParkingCreate(dto);
        Parking parking = service.update(id, parkingCreate);
        ParkingDTO result = parkingMapper.toParkingDTO(parking);

        return ResponseEntity.status(HttpStatus.OK).body(result);

    }

    @PostMapping("/{id}")
    @ApiOperation("Check Out parkings")
    public ResponseEntity<ParkingDTO> checkOut(@PathVariable String id) {

        Parking parking = service.checkOut(id);
        ParkingDTO result = parkingMapper.toParkingDTO(parking);

        return ResponseEntity.status(HttpStatus.OK).body(result);

    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete by parking for id")
    public ResponseEntity delete(@PathVariable String id) {
        service.delete(id);

        return ResponseEntity.noContent().build();

    }

}
