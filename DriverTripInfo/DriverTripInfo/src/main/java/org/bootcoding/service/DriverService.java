package org.bootcoding.service;

import org.bootcoding.model.Drivers;

import java.util.List;

public interface DriverService
{
    void insert(Drivers drivers);

    List<Drivers> getAll();

    
}
