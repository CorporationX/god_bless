package faang.school.godbless.supercow;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    private static final int MAX_PLAYERS = 5;

    private static final int PLAYERS_QUEUE = 10;

    public static void main(String[] args) {
        Boss boss = new Boss(MAX_PLAYERS);

        List<Player> players = new ArrayList<>();
        for (int i = 0; i < PLAYERS_QUEUE; i++) {
            players.add(new Player("Player" + i));
        }

        ExecutorService executorService = Executors.newCachedThreadPool();
        players.forEach(player -> executorService.execute(() -> player.startBattle(boss)));

        executorService.shutdown();
    }
}
