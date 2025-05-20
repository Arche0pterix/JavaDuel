package org.example;

import java.util.ArrayList;

public class LocationManager {

    ArrayList<Room> room = new ArrayList<Room>();
    public int roomCounter = 0;
    public LocationManager(){
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
        room.add(new Room("Id 0,First room", 0, 0));
        room.add(new Room("Id 1", 1, 1));
        room.add(new Room("Id 2", 2, 2));
        room.add(new Room("Id 3", 3, 3));
        room.add(new Room("Id 4", 4, 4));
        room.add(new Room("Healing Shrine", 5, 5));
        room.add(new Room("Id 6", 6, 6));
        room.add(new Room("Id 7", 7, 7));
        room.add(new Room("Id 8", 8, 8));
        room.add(new Room("Id 9,Final room", 9, 9));
    }

    public Room moveForward() {
        roomCounter++;
        return this.room.get(roomCounter);
    }

    public Room goBack() {
        roomCounter--;
        return this.room.get(roomCounter);
    }

}
/*

//room like dungeon . С возможностью вернутся .
room 1
____
battleSeq;
randomGear;
%shrine;
next
___
room 2
battleSeq;
%randomGear;/sell/throw away gear.
%shrine;
next or back?
----
room 3
chest etc.
%randomGear;
%shrine;
next or back?
...
room 5
hp recovery/rest
...
room 10
battleSeq;Boss?
%randomGear;
%shrine;
back/change location/restart location?
finish
 */