package org.example;

import java.util.ArrayList;

public class LocationManager {

    ArrayList<Room> rooms = new ArrayList<Room>();
    public int roomCounter = 0;

    public LocationManager() {
        roomList();
    }

    public Locations locationPicker(Duelist duelist1) {
        ArrayList<Locations> locations = new ArrayList<Locations>();
        locations.add(new Locations("Forest Dungeon", 0, 0));
        locations.add(new Locations("Swamp Crypt", 3, 1));
        locations.add(new Locations("Frozen Hole", 5, 2));
        if (duelist1.level >= 5) {
            return locations.get(2);
        } else if (duelist1.level >= 3) {
            return locations.get(1);
        } else {
            return locations.get(0);
        }
    }

    public void roomList() {
        rooms.add(new Room("Id 0,First room", 0, 0, false));
        rooms.add(new Room("Id 1", 1, 1, false));
        rooms.add(new Room("Id 2", 2, 2, false));
        rooms.add(new Room("Id 3", 3, 3, false));
        rooms.add(new Room("Id 4", 4, 4, false));
        rooms.add(new Room("Healing Shrine", 5, 5, false));
        rooms.add(new Room("Id 6", 6, 6, false));
        rooms.add(new Room("Id 7", 7, 7, false));
        rooms.add(new Room("Id 8", 8, 8, false));
        rooms.add(new Room("Id 9,Final room", 9, 9, false));
    }

    public boolean isRoomCompleted() {
        return rooms.get(roomCounter).roomCompleted;

    }

    public Room moveForward() {
        rooms.get(roomCounter).roomCompleted = true;
        for (int i = 0; i < rooms.size(); i++) {
            System.out.println(i + " la" + rooms.get(i).roomCompleted);
        }
        roomCounter++;
        if (roomCounter > rooms.size()) {
            roomCounter = rooms.size();
            return rooms.get(roomCounter);
        } else if (roomCounter < 0) {
            return rooms.get(0);
        } else return rooms.get(roomCounter);
    }

    public Room goBack() {
        for (int i = 0; i < rooms.size(); i++) {
            System.out.println(i + " la" + rooms.get(i).roomCompleted);
        }
        roomCounter--;
        if (roomCounter < 0) {
            roomCounter = 0;
            return rooms.get(roomCounter);
        } else return rooms.get(roomCounter);
    }

    public String getRoomName() {
        return rooms.get(roomCounter).roomType;
    }


}

/*


если я был в номнате -> убрать все спавны - пустая .
добавить true/false на чек после енкаунтера , сохранаять в коллекции из 10 комнат , в которых я буду
 */