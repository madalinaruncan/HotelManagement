package com.ubb.postuniv.Domain;

public class AverageBedNumber {
    public String type;
    public float bedNumber;

    public AverageBedNumber(String type, float bedNumber) {
        this.type = type;
        this.bedNumber = bedNumber;
    }

    @Override
    public String toString() {
        return "AverageBedNumber{" +
                "type='" + type + '\'' +
                ", bedNumber=" + bedNumber +
                '}';
    }
}
