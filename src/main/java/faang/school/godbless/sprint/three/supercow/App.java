package faang.school.godbless.sprint.three.supercow;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class App {
    public static void main(String... args) {
        List<Player> players = new ArrayList<>(List.of(
                new Player("Vasia"), new Player("Kolia"),
                new Player("Petia"), new Player("Tolik"),
                new Player("John"), new Player("Dan")
        ));
        Boss boss = new Boss();

        ExecutorService executor = Executors.newCachedThreadPool();
        players.forEach(player -> executor.execute(() -> player.startBattle(boss)));
        executor.shutdown();

        try {
            if (!executor.awaitTermination(Constants.MAX_APP_EXECUTION_TIME, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }

        System.out.println("Finish");
    }
}
