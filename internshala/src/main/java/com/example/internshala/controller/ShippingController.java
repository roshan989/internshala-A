package com.example.internshala.controller;

import com.example.internshala.model.Ship;
import com.example.internshala.service.ShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/load")
@RestController
public class ShippingController {

    private ShipService shipService;
    @Autowired
    public ShippingController(@Qualifier("A_Ship") ShipService shipService) {
        this.shipService = shipService;
    }

    @GetMapping(path="{shipperId}")
    public List<Ship> getList(@PathVariable("shipperId") UUID id){
        return shipService.getList(id);
    }

    @PostMapping
    public void insertShipment(@RequestBody Ship ship){
        shipService.addShipment(ship);
    }

    @DeleteMapping(path = "{loadid}")
    public void deleteShipment(@PathVariable("loadid") UUID id){
        shipService.deleteShipment(id);
    }

    @PutMapping(path = "{loadid}")
    public int putShipment(@PathVariable("loadid") UUID id,@RequestBody Ship ship){
        return shipService.putShipment(id,ship);
    }
}
