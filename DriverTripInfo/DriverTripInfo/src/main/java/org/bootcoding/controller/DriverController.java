package org.bootcoding.controller;

import org.bootcoding.model.Drivers;
import org.bootcoding.model.Trip;
import org.bootcoding.service.DriverService;
import org.bootcoding.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DriverController {

    @Autowired
    private DriverService driverService;

    @PostMapping("/createDriver")
    @ResponseBody
    public ResponseEntity createDriver(@RequestBody Drivers drivers){
        driverService.insert(drivers);
        System.out.println("Driver details inserted in Database.");
        return new ResponseEntity("Driver created successfully....",HttpStatus.CREATED);
    }

    @GetMapping("/allDrivers")
    public List<Drivers> getAll(){
        return driverService.getAll();
    }

    @PutMapping("/updateDriver")
    public Drivers update(@RequestBody Drivers drivers){
        return driverService.update(drivers);

    }
    @DeleteMapping("/drivers/{id}")
    @ResponseBody
    public ResponseEntity delete(@PathVariable int id){
        driverService.delete(id);
        return new ResponseEntity<>("Deleted Successfully...",HttpStatus.OK);
    }

    @GetMapping("/drivers/id/{id}")
    public Drivers getById(@PathVariable int id){
        return driverService.getById(id);
    }

    //trip


}
