package faang.school.godbless.supercow;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Boss testBoss = new Boss(3);
        List<Player> players = new ArrayList<>();
        players = List.of(new Player("John"), new Player("Sam"),
                new Player("Ginger"), new Player("Vin"),
                new Player("Din"), new Player("Dan"));

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (Player player : players) {
            executorService.execute(() -> {
                try {
                    player.startBattle(testBoss);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        executorService.shutdown();
    }
}
