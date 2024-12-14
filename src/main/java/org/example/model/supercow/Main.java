package org.example.model.supercow;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<Player> players = new ArrayList<>();
        Boss boss = new Boss(10, 5);
        for (int i = 0; i < 10; i++) {
            Player newPlayer = new Player("player " + i);
            players.add(newPlayer);
            new Thread(() -> {
                try {
                    newPlayer.startBattle(boss);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }
        Thread.sleep(5000);
        for (int i = 0; i < 5; i++) {
            int finalI = i;
            new Thread(() -> {
                players.get(finalI).endBattle(boss);
            }).start();
        }
    }
}
