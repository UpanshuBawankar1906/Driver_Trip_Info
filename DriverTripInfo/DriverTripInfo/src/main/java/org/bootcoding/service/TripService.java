package org.bootcoding.service;

import org.bootcoding.model.Drivers;
import org.bootcoding.model.Trip;

import java.util.List;

public interface TripService {
    void insert(Trip trip);

    List<Trip> getAll();


    Trip update(Trip trip);

    void delete(int id);

    Trip getById(int id);
}
