package com.github.antonioticelso.cloudParking.service;

import com.github.antonioticelso.cloudParking.exception.ParkingNotFoundException;
import com.github.antonioticelso.cloudParking.model.Parking;
import com.github.antonioticelso.cloudParking.model.ParkingCheckOut;
import com.github.antonioticelso.cloudParking.repository.ParkingRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ParkingService {

    private final ParkingRepository repository;


    public ParkingService(ParkingRepository repository) {
        this.repository = repository;
    }

    public List<Parking> findAll() {
        return repository.findAll();
    }

    private static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public Parking findById(String id) {
        return repository.findById(id).orElseThrow(() -> new ParkingNotFoundException(id));

    }

    public Parking create(Parking parkingCreate) {
        String id = getUUID();
        parkingCreate.setId(id);
        parkingCreate.setEntryDate(LocalDateTime.now());
        repository.save(parkingCreate);

        return parkingCreate;

    }

    public void delete(String id) {
        findById(id);
        repository.deleteById(id);

    }

    public Parking update(String id, Parking parkingCreate) {
        Parking parking = findById(id);
        parking.setColor(parkingCreate.getColor());
        parking.setState(parkingCreate.getState());
        parking.setModel(parkingCreate.getModel());
        parking.setLicense(parkingCreate.getLicense());

        repository.save(parking);

        return parking;

    }

    public Parking checkOut(String id) {
        Parking parking = findById(id);
        parking.setExitDate(LocalDateTime.now());
        parking.setBill(ParkingCheckOut.getBill(parking));
        repository.save(parking);

        return parking;
    }

}
