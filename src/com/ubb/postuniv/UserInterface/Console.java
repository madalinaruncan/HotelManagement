package com.ubb.postuniv.UserInterface;

import com.ubb.postuniv.Domain.AverageBedNumber;
import com.ubb.postuniv.Domain.Room;
import com.ubb.postuniv.Domain.RoomProfitabilityDTO;
import com.ubb.postuniv.Service.RoomService;

import java.util.Scanner;

public class Console {
    private final RoomService roomService;
    private final Scanner scan;

    public Console(RoomService roomService) {
        this.roomService = roomService;
        this.scan = new Scanner(System.in);
    }

    /**
     * Show to user the features of the program.
     */
    private void menuText() {
        System.out.println("1. Add a room.");
        System.out.println("2. Show all rooms.");
        System.out.println("3. Update a room.");
        System.out.println("4. Delete a room.");
        System.out.println("5. Show profitability report.");
        System.out.println("6. Show average bed number per type.");
        System.out.println("0. Leave program.");
        System.out.println("Enter your option: ");
    }

    /**
     * Gets the room information from user.
     * Expected exception if the input doesn't match the data type.
     */
    private void addRoomChoice() {
        try {
            System.out.print("Enter room id: ");
            int id = scan.nextInt();
            System.out.print("Enter room name: ");
            String name = scan.next();
            System.out.print("Enter room price per night accommodation: ");
            float price = scan.nextFloat();
            System.out.print("Enter the number of beds in the room: ");
            int bedNumber = scan.nextInt();
            System.out.print("Enter room type: ");
            String type = scan.next();
            this.roomService.addRoom(id, name, price, bedNumber, type);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Shows the list of rooms.
     */
    private void showRoomsChoice() {
        for (Room room :
                this.roomService.getRooms()) {
            System.out.println(room);
        }
    }

    /**
     * Gets the updated information from the user.
     */
    private void updateRoomChioice() {
        try {
            System.out.println("Enter the id of the room you want to update: ");
            int id = scan.nextInt();
            System.out.print("Enter updated room name: ");
            String name = scan.next();
            System.out.print("Enter updated room price per night accommodation: ");
            float price = scan.nextFloat();
            System.out.print("Enter the updated number of beds in the room: ");
            int bedNumber = scan.nextInt();
            System.out.print("Enter updated room type: ");
            String type = scan.next();
            Room updatedRoom = new Room(id, name, price, bedNumber, type);
            this.roomService.updateRoom(updatedRoom);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Gets the id of the room the user wants to delete.
     * @throws Exception if the id doesn't exist.
     */
    public void deleteRoomChoice() throws Exception{
            System.out.println("Enter the id of the room you want to delete: ");
            int id = scan.nextInt();
            this.roomService.deleteRoom(id);
    }

    private void profitabilityReportChoice() {
        for (RoomProfitabilityDTO room:
                this.roomService.roomProfitabilities()) {
            System.out.println(room);
        }
    }

    private void averageBedNumberChoice(){
        for (AverageBedNumber abn : this.roomService.getTypesWithAverageBedNumber()){
            System.out.println(abn);
        }
    }

    public void runConsole() throws Exception {
        while (true) {
            this.menuText();
            int option = this.scan.nextInt();
            switch (option) {
                case 1:
                    this.addRoomChoice();
                    break;
                case 2:
                    this.showRoomsChoice();
                    break;
                case 3:
                    this.updateRoomChioice();
                    break;
                case 4:
                    this.deleteRoomChoice();
                    break;
                case 5:
                    this.profitabilityReportChoice();
                    break;
                case 6:
                    this.averageBedNumberChoice();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Wrong command.");
            }
        }
    }

}
