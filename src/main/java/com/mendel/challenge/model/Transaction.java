package com.mendel.challenge.model;

import lombok.Data;

@Data
public class Transaction {

    private Long id;
    private String type;
    private Long parent_id;
    private double amount;
}
