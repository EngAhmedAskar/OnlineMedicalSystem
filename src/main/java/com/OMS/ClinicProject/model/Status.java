package com.OMS.ClinicProject.model;

public enum Status {
    Reserved(0) ,
    Cancelled(1),
    completed(2);


    private final int value;

    private Status(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
