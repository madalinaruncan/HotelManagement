package com.ubb.postuniv.Repository;

import com.ubb.postuniv.Domain.Room;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RoomRepository {
    private Map<Integer, Room> hotel = new HashMap<>();

    public RoomRepository() {
    }

    /**
     * Add a part object to repository.
     *
     * @param room, the Room object to add.
     * @throws Exception if the ID already exists.
     */
    public void create(Room room) throws Exception {
        if (this.hotel.containsKey(room.getId())) {
            throw new Exception("It looks like there is already a room with " + room.getId() + " ID.");
        }
        this.hotel.put(room.getId(), room);
    }

    /**
     * Creates a list of all Room objects.
     * @return a list of all Room objects.
     */
    public List<Room> read() {
        return new ArrayList<>(this.hotel.values());
    }

    /**
     * Updates an existent Room object.
     * @param room to update.
     * @throws Exception if the id doesn't exist.
     */
    public void update(Room room) throws Exception {
        if (!this.hotel.containsKey(room.getId())) {
            throw new Exception("Sorry, there is no room with " + room.getId() + " ID.");
        }
        this.hotel.put(room.getId(), room);
    }

    /**
     * Delete a Room object.
     * @param id of the room to delete.
     * @throws Exception if the od doesn't exist.
     */
    public void delete(int id) throws Exception{
        if (!this.hotel.containsKey(id)) {
            throw new Exception("Sorry, there is no room with " + id + " ID.");
        }
        this.hotel.remove(id);
    }
}
