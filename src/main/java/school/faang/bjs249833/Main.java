package school.faang.bjs249833;


import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class Main {

    public static final int MAX_PLAYERS = 2;

    public static void main(String[] args) {

        Boss boss = new Boss(MAX_PLAYERS);
        ExecutorService threadPool = Executors.newFixedThreadPool(3);

        for (int i = 1; i <= 3; i++) {
            int numPlayer = i;

            threadPool.submit(() -> {
                Player player1 = new Player("Player " + numPlayer);
                player1.startBattle(boss);
            });
        }
        threadPool.shutdown();
    }
}
