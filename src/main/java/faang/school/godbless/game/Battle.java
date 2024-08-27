package faang.school.godbless.game;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class Battle {
    public static void main(String[] args) throws InterruptedException {
        Boss boss = new Boss(3);
        List<Player> players = new ArrayList<>(List.of(
                new Player("Vasya"),
                new Player("Biba"),
                new Player("Boba"),
                new Player("Bob"),
                new Player("Tom")
        ));

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        executorService.execute(() -> players.forEach(player -> player.startBattle(boss)));
        executorService.execute(() -> {
            for (int i = 0; i <= 100; i++) {
                boss.killPlayer();
            }
        });

        executorService.shutdown();
        executorService.awaitTermination(5L, TimeUnit.SECONDS);

        System.out.println("FIN");
    }
}
