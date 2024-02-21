package org.bootcoding.service;
import org.bootcoding.model.Drivers;
import org.bootcoding.repo.DriverRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DriverServiceImpl implements DriverService{
    @Autowired
    private DriverRepo repo;
    @Override
    public void insert(Drivers drivers) {
        repo.insert(drivers);
    }
    @Override
    public List<Drivers> getAll() {
        return repo.getAll();
    }
    @Override
    public Drivers update(Drivers drivers){
        return repo.update(drivers);
    }
    @Override
    public void delete(int id){
        repo.delete(id);
    }
    @Override
    public Drivers getById(int id) {
        return repo.getById(id);
    }
}
