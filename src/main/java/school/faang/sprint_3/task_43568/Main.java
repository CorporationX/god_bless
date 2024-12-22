package school.faang.sprint_3.task_43568;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final int POOL_SIZE = 5;
    private static final int MAX_PLAYERS = 2;

    public static void main(String[] args) {
        Boss boss = new Boss(MAX_PLAYERS);

        List<Player> players = new ArrayList<>(List.of(
                new Player("Ксюша"), new Player("Таня"), new Player("Кирилл"),
                new Player("Даниил"), new Player("Ваня")
        ));

        ExecutorService executor = Executors.newFixedThreadPool(POOL_SIZE);

        players.forEach(player -> executor.execute(() -> player.fight(boss)));

        executor.shutdown();
    }
}
