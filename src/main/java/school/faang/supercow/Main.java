package school.faang.supercow;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss(3);

        Player[] players = {
                new Player("Игрок 1"),
                new Player("Игрок 2"),
                new Player("Игрок 3"),
                new Player("Игрок 4"),
                new Player("Игрок 5")
        };

        ExecutorService service = Executors.newFixedThreadPool(5);


        for (Player player : players) {
            service.submit(() -> {
                player.startBattle(boss);
            });
        }

        service.shutdown();
    }
 }

