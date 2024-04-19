package faang.school.godbless.synchronization.task_3;

import faang.school.godbless.synchronization.task_3.model.Boss;
import faang.school.godbless.synchronization.task_3.model.Player;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final int MAX_PLAYERS = 1;
    private static final int POOL_SIZE = 2;
    private static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(POOL_SIZE);

    public static void main(String[] args) throws InterruptedException {
        Boss boss = new Boss(MAX_PLAYERS);
        List<Player> players = getPlayers();
        players.forEach(player -> EXECUTOR.execute(() -> player.startBattle(boss)));
        EXECUTOR.shutdown();
    }


    private static List<Player> getPlayers() {
        Player ignat = new Player("ignat");
        Player fedor = new Player("fedor");
        Player masha = new Player("masha");
        Player ivan = new Player("ivan");
        Player katya = new Player("katya");
        return List.of(ignat, fedor, masha, ivan, katya);
    }
}