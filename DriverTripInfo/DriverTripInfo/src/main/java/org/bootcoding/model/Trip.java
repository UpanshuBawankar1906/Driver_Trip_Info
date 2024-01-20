package org.bootcoding.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Trip {
    private String d_name;
    private int d_id;
    private String start_location;
    private String end_location;
    private double distance;
    private double fare;
}
