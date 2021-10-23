package com.example.internshala.repo;

import com.example.internshala.model.Ship;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface InterfaceRepo {
    int addShipment(String comment, UUID id, Date date,Ship ship);

    default int addShipment(Ship ship){
        UUID id=UUID.randomUUID();
        String comment="null";
        Date date=Date.from(Instant.now());
        return addShipment(comment,id,date,ship);
    }
    List<Ship> getShipping(UUID id);
    int putShipping(UUID id,Ship ship);
    int deleteShipping(UUID id);
}
