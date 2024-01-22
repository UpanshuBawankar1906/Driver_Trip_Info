package org.bootcoding.controller;

import org.bootcoding.model.Trip;
import org.bootcoding.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TripController {
    @Autowired
    private TripService tripService;

    @PostMapping("/createTrip")
    @ResponseBody
    public ResponseEntity createDriver(@RequestBody Trip trip){
        tripService.insert(trip);
        System.out.println("Trip details inserted in Database.");
        return new ResponseEntity("Trip created successfully....", HttpStatus.CREATED);
    }

    @GetMapping("/allTrip")
    public List<Trip> getAll(){
        return tripService.getAll();
    }

    @PutMapping("/updateTrip")
    public Trip update(@RequestBody Trip trip){
        return tripService.update(trip);

    }
    @DeleteMapping("/Trip/{id}")
    @ResponseBody
    public ResponseEntity delete(@PathVariable int id){
        tripService.delete(id);
        return new ResponseEntity<>("Deleted Successfully...",HttpStatus.OK);
    }

    @GetMapping("/trip/id/{id}")
    public Trip getById(@PathVariable int id){
        return tripService.getById(id);
    }
}
