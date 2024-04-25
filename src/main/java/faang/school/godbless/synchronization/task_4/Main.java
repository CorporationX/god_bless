package faang.school.godbless.synchronization.task_4;

import faang.school.godbless.synchronization.task_4.model.Game;
import faang.school.godbless.synchronization.task_4.model.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final int POOL_SIZE = 2;
    private static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(POOL_SIZE);

    public static void main(String[] args) {
        List<Player> players = new ArrayList<>();
        players.add(new Player("ignat", 12, true));
        players.add(new Player("larisa", 7, true));
        Game game = new Game(players);

        for (int index = 0; index < players.size(); index++) {
            EXECUTOR.execute(game::update);
        }
        EXECUTOR.shutdown();
    }
}