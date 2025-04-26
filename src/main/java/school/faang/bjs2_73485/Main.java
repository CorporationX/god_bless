package school.faang.bjs2_73485;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        Boss boss = new Boss(5);

        List<Player> players = new ArrayList<>(List.of(
                new Player("1"),
                new Player("2"),
                new Player("3"),
                new Player("4"),
                new Player("5"),
                new Player("6"),
                new Player("7"),
                new Player("8"),
                new Player("9"),
                new Player("10")
        ));

        ExecutorService executor = Executors.newCachedThreadPool();

        for (Player player : players) {
            executor.execute(() -> player.doBattle(boss));
        }

        executor.shutdown();

        try {
            if (!executor.awaitTermination(5, TimeUnit.MINUTES)) {
                System.out.println("Задачи не завершились за 5 минут, принудительно останавливаем...");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}
