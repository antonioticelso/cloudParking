package com.github.antonioticelso.cloudParking.service;

import com.github.antonioticelso.cloudParking.model.Parking;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ParkingService {

    private static Map<String, Parking> parkingMap = new HashMap<>();

    static {
        var id1 = getUUID();
        Parking parking1 = new Parking(id1, "WBC-007", "DF", "BMW", "PRETA");
        parkingMap.put(id1, parking1);

        var id2 = getUUID();
        Parking parking2 = new Parking(id2, "JCO-171", "DF", "PARATI", "PRATA");
        parkingMap.put(id2, parking2);
    }

    public List<Parking> findAll() {
        return parkingMap.values().stream().collect(Collectors.toList());
    }

    private static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public Parking findById(String id) {
        return parkingMap.get(id);
    }

    public Parking create(Parking parkingCreate) {
        String id = getUUID();
        parkingCreate.setId(id);
        parkingCreate.setEntryDate(LocalDateTime.now());
        parkingMap.put(id, parkingCreate);

        return parkingCreate;

    }

}
