package com.example.internshala.service;

import com.example.internshala.model.Ship;
import com.example.internshala.repo.InterfaceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service(value = "A_Ship")
public class ShipService {

    private final InterfaceRepo interfaceRepo;

    @Autowired
    public ShipService(@Qualifier("shipA") InterfaceRepo interfaceRepo) {
        this.interfaceRepo = interfaceRepo;
    }

    public List<Ship> getList(UUID id){
        return interfaceRepo.getShipping(id) ;
    }

    public int addShipment(Ship ship){
        return interfaceRepo.addShipment(ship);
    }

    public int deleteShipment(UUID id){
        return interfaceRepo.deleteShipping(id);
    }

    public int putShipment(UUID id,Ship ship){
        return interfaceRepo.putShipping(id,ship);
    }
}
