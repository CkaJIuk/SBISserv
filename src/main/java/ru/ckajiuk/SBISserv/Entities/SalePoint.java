package ru.ckajiuk.SBISserv.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SalePoint {
    private int id;
    private String name;
    private String phone;
    private String address;
}