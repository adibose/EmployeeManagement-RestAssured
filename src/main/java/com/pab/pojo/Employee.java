package com.pab.pojo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder(setterPrefix = "set")
public class Employee {

    private int id;
    private String fname;
    private String lname;
    private String email;
}
