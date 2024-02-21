package org.bootcoding.service;
import org.bootcoding.model.Drivers;
import org.bootcoding.model.Trip;
import org.bootcoding.repo.DriverRepo;
import org.bootcoding.repo.TripRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class TripServiceImpl implements TripService{
    @Autowired
    private TripRepo repo;
    @Override
    public void insert(Trip trip) {
        repo.insert(trip);
    }
    @Override
    public List<Trip> getAll() {
        return repo.getAll();
    }
    @Override
    public Trip update(Trip trip){
        return repo.update(trip);
    }
    @Override
    public void delete(int id){
        repo.delete(id);
    }
    @Override
    public Trip getById(int id) {
        return repo.getById(id);
    }
}
