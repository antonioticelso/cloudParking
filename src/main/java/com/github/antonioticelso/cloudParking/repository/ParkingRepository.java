package com.github.antonioticelso.cloudParking.repository;

import com.github.antonioticelso.cloudParking.model.Parking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingRepository extends JpaRepository<Parking, String> {
}
