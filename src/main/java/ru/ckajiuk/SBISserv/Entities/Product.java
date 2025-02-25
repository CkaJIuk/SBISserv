package ru.ckajiuk.SBISserv.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Product {
    private int id;
    private String name;
    private int cost;
    private String unit;
    private int balance;
    private String imageurl;
    private boolean isParent;
}
