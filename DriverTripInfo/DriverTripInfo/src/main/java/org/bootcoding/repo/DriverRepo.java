package org.bootcoding.repo;

import org.bootcoding.model.Drivers;

import java.sql.Driver;
import java.util.List;

public interface DriverRepo {
    Drivers insert(Drivers drivers);

    List<Drivers> getAll();

    Drivers update(Drivers drivers);

    void delete(int id);

    Drivers getById(int id);
}
