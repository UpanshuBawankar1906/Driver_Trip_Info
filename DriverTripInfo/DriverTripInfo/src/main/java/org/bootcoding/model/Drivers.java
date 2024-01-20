package org.bootcoding.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Drivers {
    private int id;
    private String name;
    private String  phone_no;
    private String license_no;
    private String address;
    private int age;
    private String  gender;
    private int exp;


}
