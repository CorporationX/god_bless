package com.multithreading.force;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        try {
            Player player1 = new Player("Vasya", 2);
            Player player2 = new Player("Petya", 4);
            Player player3 = new Player("Nastya", 2);

            game.addPlayer(player1);
            game.addPlayer(player2);
            game.addPlayer(player3);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }

        ExecutorService service = Executors.newFixedThreadPool(2);
        for (Player player : game.getPlayers()) {
            service.execute(() -> game.update(player));
        }
        service.shutdown();
        try {
            service.awaitTermination(4, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        game.getStatistics();
    }
}
