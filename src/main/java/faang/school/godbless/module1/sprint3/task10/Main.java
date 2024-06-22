package faang.school.godbless.module1.sprint3.task10;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        List<Player> players = List.of(new Player("Victor"), new Player("Semen"), new Player("Kate"),
                new Player("Fred"));
        Boss boss = new Boss(2);
        ExecutorService service = Executors.newFixedThreadPool(10);

        for (Player player : players) {
            service.submit(() -> {
                try {
                    player.startBattle(boss);
                    boss.battleOver(player);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        service.shutdown();

    }
}
