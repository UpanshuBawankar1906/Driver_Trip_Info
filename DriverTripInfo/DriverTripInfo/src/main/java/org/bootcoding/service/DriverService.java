package org.bootcoding.service;
import org.bootcoding.model.Drivers;
import java.util.List;

public interface DriverService
{
    void insert(Drivers drivers);
    List<Drivers> getAll();
    Drivers update(Drivers drivers);

    void delete(int id);
    Drivers getById(int id);
}
