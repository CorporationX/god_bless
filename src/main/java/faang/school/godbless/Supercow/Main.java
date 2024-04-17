package faang.school.godbless.Supercow;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        List<Player> players = getPlayers();
        Boss boss = new Boss(3);

        ExecutorService pool = Executors.newFixedThreadPool(players.size());
        players.forEach(player -> pool.execute(() -> player.startBattle(boss)));
        pool.shutdown();

        try {
            while (pool.awaitTermination(10, TimeUnit.SECONDS)) ;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static List<Player> getPlayers() {
        List<Player> players = new ArrayList<>();
        players.add(new Player("cooldude"));
        players.add(new Player("awesomeguy"));
        players.add(new Player("beautifulbutterfly"));
        players.add(new Player("shinyrock"));
        players.add(new Player("sillysquirrel"));
        return players;
    }
}
