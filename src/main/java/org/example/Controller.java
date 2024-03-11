package org.example;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Controller {

    List<Integer> statistics;

    Game game;

    public Controller() {
        play();
        printStats(statistics);
    }
    private void play() {
        for(int i = 0; i < 20; i++){
            this.game = new Game();
            System.out.println("------------------------------------------------------------");
        }
        getStats(Game.winsCounter, Game.loosesCounter);
    }
    private void getStats(int wins, int looses){
        this.statistics = new ArrayList<>();
        statistics.add(wins);
        statistics.add(looses);
    }

    private void printStats(List<Integer> list){
        System.out.println("Побед: " + list.get(0) + " Поражений: " + list.get(1));
    }
}
