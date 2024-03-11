package org.example;

import java.util.ArrayList;
import java.util.List;

public class Player {

    List<Door> doors;

    Player(){
        this.doors = checkIfDoorsNotEmpty(createDoors());
    }

    private List<Door> createDoors(){
        List<Door> doors = new ArrayList<>();
        for(int i = 0; i < 3; i++){
            doors.add(new Door());
        }
        return doors;
    }

    private List<Door> checkIfDoorsNotEmpty(List<Door> doors){
        int check = 0;
        for (Door door: doors) {
            if (door.getFlag()){
                check += 1;
            }
        }
        if (check == 0){
            doors.get(doors.size() - 1).setFlag(true);
        }
        return doors;
    }

    public void removeDoor(Door door){
        this.doors.remove(door);
    }

    public Door openWrongDoor() {
        Door door1 = null;
        for (Door door : doors) {
            if (!door.getFlag()) {
                door1 = door;
            }
        }
        System.out.println("А вот дверца с козочкой: " + door1);
        return door1;
    }
    public Door rightDoor(){
        Door rightDoor = null;
        for (Door door : doors) {
            if (door.getFlag()){
                rightDoor = door;
            }
        }
        return rightDoor;
    }
}
