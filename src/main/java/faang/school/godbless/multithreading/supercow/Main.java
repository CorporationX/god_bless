package faang.school.godbless.multithreading.supercow;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Boss boss = new Boss(3, 0);

        List<Player> players = List.of(new Player("Jonh"), new Player("Ann"),
        new Player("Mike"), new Player("Ura"), new Player("Roma"), new Player("Bob"));

        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (Player player : players) {
            executor.execute(() -> {
                try {
                    player.startBattle(boss);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        executor.shutdown();
    }
}