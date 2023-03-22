package com.ubb.postuniv;

import com.ubb.postuniv.Domain.RoomValidator;
import com.ubb.postuniv.Repository.RoomRepository;
import com.ubb.postuniv.Service.RoomService;
import com.ubb.postuniv.UserInterface.Console;

public class Main {
    public static void main(String[] args) throws Exception {
        RoomRepository roomRepository = new RoomRepository();
        RoomValidator roomValidator = new RoomValidator();
        RoomService roomService = new RoomService(roomRepository, roomValidator);

        roomService.addRoom(1, "Twin Bedroom", 200, 2, "Regular");
        roomService.addRoom(2, "King Bedroom", 300, 3, "Business");
        roomService.addRoom(3, "Sea view apartament", 400, 3, "Executive");
        roomService.addRoom(4, "Panoramic view suite", 720, 3, "VIP");
        roomService.addRoom(5, "Panoramic view suite", 900, 5, "VIP");
        roomService.addRoom(6, "Queen Bedroom", 220, 1, "Regular");
        roomService.addRoom(7, "Garden view apartament", 450, 4, "Executive");
        roomService.addRoom(8, "Sea view apartamanet", 480, 4, "Executive");

        Console console = new Console(roomService);

        console.runConsole();
    }
}