package com.ubb.postuniv.Service;

import com.ubb.postuniv.Domain.AverageBedNumber;
import com.ubb.postuniv.Domain.Room;
import com.ubb.postuniv.Domain.RoomProfitabilityDTO;
import com.ubb.postuniv.Domain.RoomValidator;
import com.ubb.postuniv.Repository.RoomRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RoomService {
    private RoomRepository roomRepository;
    private RoomValidator roomValidator;

    public RoomService(RoomRepository roomRepository, RoomValidator roomValidator) {
        this.roomRepository = roomRepository;
        this.roomValidator = roomValidator;
    }

    /**
     * Adds a Room object to repository.
     * @param id of the room.
     * @param name of the room.
     * @param price of the room.
     * @param bedNumber of the room.
     * @param type of the room.
     * @throws Exception if the id already exists.
     */
    public void addRoom(int id, String name, float price, int bedNumber, String type) throws Exception {
        Room room = new Room(id, name, price, bedNumber, type);
        this.roomValidator.validate(room);
        this.roomRepository.create(room);
    }

    /**
     * Gets a list of all Room objects.
     * @return a list of all Room objects.
     */
    public List<Room> getRooms() {
        return this.roomRepository.read();
    }

    /**
     * Updates a Room object information
     * @param room to update
     * @throws Exception if the id doesn't exist.
     */
    public void updateRoom(Room room) throws Exception{
        this.roomValidator.validate(room);
        this.roomRepository.update(room);
    }

    /**
     * Delete a Room object.
     * @param id of the room to delete.
     * @throws Exception if the id doesn't exist.
     */
    public void deleteRoom(int id) throws Exception{
        this.roomRepository.delete(id);
    }

    /**
     * Creates a list of room by its profitability rate (price per bed)
     * @return the list of rooms sorted by profitability
     */
    public List<RoomProfitabilityDTO> roomProfitabilities() {
        List<Room> rooms = this.getRooms();
        List<RoomProfitabilityDTO> result = new ArrayList<>();
        for (Room room:
                rooms) {
            result.add(new RoomProfitabilityDTO(room, room.getPrice() / room.getBedNumber()));
        }
        for (int i = 0; i < result.size(); ++i) {
            for (int j = i+1; j < result.size(); ++j) {
                if (result.get(i).pricePerBed < result.get(j).pricePerBed) {
                    RoomProfitabilityDTO aux = result.get(i);
                    result.set(i, result.get(j));
                    result.set(j, aux);
                }
            }
        }
        return result;
    }

    public List<AverageBedNumber> getTypesWithAverageBedNumber() {
        Map<String, List<Integer>> typesBedNumber = new HashMap<>();
        for (Room r: this.getRooms()) {
            String type = r.getType();
            int bedNumber = r.getBedNumber();
            if (!typesBedNumber.containsKey(type)) {
                typesBedNumber.put(type, new ArrayList<>());
            }
            typesBedNumber.get(type).add(bedNumber);
        }

        List<AverageBedNumber> result = new ArrayList<>();
        for (String type : typesBedNumber.keySet()) {
            float average = 0;
            for (int bedsNumber : typesBedNumber.get(type)) {
                average += bedsNumber;
            }
            average /= typesBedNumber.get(type).size();

            result.add(new AverageBedNumber(type, average));
        }

        return result;
    }
}
