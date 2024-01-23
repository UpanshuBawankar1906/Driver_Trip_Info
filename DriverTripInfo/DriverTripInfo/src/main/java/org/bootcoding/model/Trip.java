package org.bootcoding.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Trip {
    private int id;
    private int driverid;
    private String drivername;
    private String start_location;
    private String end_location;
    private float distance;
    private double fare;
}
