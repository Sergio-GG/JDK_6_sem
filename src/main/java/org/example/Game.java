package org.example;

import java.util.List;
import java.util.Random;

public class Game  {
    Player player;
    Door rightDoor;


    static int winsCounter = 0;
    static int loosesCounter = 0;
    Game() {
        this.player = new Player();
        this.rightDoor = player.rightDoor();
        Door possibleDoor = chooseTheDoor();
        removeWrongDoor();
        pickDoor(possibleDoor);
    }

    private Door chooseTheDoor(){
        Random random = new Random();
        Door door = player.doors.get(random.nextInt(0,player.doors.size() - 1));
        System.out.println("Выбранная дверь: " + door);
        player.removeDoor(door);
        return door;
    }

    private void removeWrongDoor(){
        Door wrongDoor = player.openWrongDoor();
        player.removeDoor(wrongDoor);
    }

    private void pickDoor(Door door)  {
        Random random = new Random();
        int sortis = random.nextInt(2);
        switch (sortis) {
            case 0 -> {
                System.out.println("Вы не изменили свой выбор! Внимание...");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                if (door.getFlag() == rightDoor.getFlag()) {
                    System.out.println("Вы угадали дверь! Поздравляем!");
                    System.out.println("Вот правильная дверь " + door);
                    ++winsCounter;
                } else {
                    System.out.println("Вы не угадали! Возможно в следующий раз вам повезет!");
                    System.out.println("Вот правильная дверь " + player.doors.get(0));
                    ++loosesCounter;
                }
            }
            case 1 -> {
                System.out.println("Вы изменили свой выбор на: " + player.doors.get(0) + ". Это было рисково! Внимание...");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                if (player.doors.get(0).getFlag() == rightDoor.getFlag()) {
                    System.out.println("Вы угадали дверь! Поздравляем!");
                    System.out.println("Вот правильная дверь " + player.doors.get(0));
                    ++winsCounter;
                } else {
                    System.out.println("Вы не угадали! Возможно в следующий раз вам повезет!");
                    System.out.println("Вот правильная дверь " + door);
                    ++loosesCounter;
                }
            }
        }
    }
}
