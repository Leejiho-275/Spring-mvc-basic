package com.spring.mvc.restapi;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class Car {

    private String name;
    private String company;
    private List<String> goods;
}
