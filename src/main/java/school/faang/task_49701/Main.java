package school.faang.task_49701;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class Main {
    private static final int MAX_PLAYERS = 2;
    private static final int NUM_PLAYERS = 3;

    public static void main(String[] args) {

        Boss boss = new Boss(MAX_PLAYERS);
        List<Player> players = new ArrayList<>();
        for (int i = 0; i < NUM_PLAYERS; i++) {
            players.add(new Player("Игрок " + i));
        }

        ExecutorService executor = Executors.newFixedThreadPool(NUM_PLAYERS);
        for (Player player : players) {
            executor.submit(() -> player.startBattle(boss));
        }

        executor.shutdown();
    }
}
