package com.ubb.postuniv.Domain;

public class RoomValidator {

    public void validate(Room room) throws Exception {
        StringBuilder sb = new StringBuilder();

        if(room.getName().equals("")){
            sb.append("The name field cannot be empty!\n");
        }

        if (room.getPrice() < 0) {
            sb.append("The price cannot be negative!\n");
        }

        if(room.getBedNumber() < 1 || room.getBedNumber() > 5){
            sb.append("The bed number must be greater than 1 and less than 5.\n");
        }

        String type = room.getType();
        if (!type.equals("Regular") && !type.equals("Business") && !type.equals("Executive") && !type.equals("VIP")) {
            sb.append("The type must be one of: Regular, Business, Executive or VIP.\n");
        }

        if (sb.length() > 0) {
            throw new Exception(sb.toString());
        }
    }
}
