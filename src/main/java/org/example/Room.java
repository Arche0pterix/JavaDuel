package org.example;

public class Room{
    String roomType;
    int roomId;
    int roomNumber;
    boolean roomCompleted;
    public Room(String roomType, int roomId , int roomNumber, boolean roomCompleted){
        this.roomType = roomType;
        this.roomId = roomId;
        this.roomNumber = roomNumber;
        this.roomCompleted = roomCompleted;
    }
}
