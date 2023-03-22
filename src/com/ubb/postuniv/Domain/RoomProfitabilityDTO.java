package com.ubb.postuniv.Domain;

public class RoomProfitabilityDTO {
    public Room room;
    public float pricePerBed;

    public RoomProfitabilityDTO(Room room, float pricePerBed) {
        this.room = room;
        this.pricePerBed = pricePerBed;
    }
    @Override
    public String toString() {
        return "RoomProfitability{" +
                "room=" + room +
                ", pricePerBed=" + pricePerBed +
                '}';
    }
}
