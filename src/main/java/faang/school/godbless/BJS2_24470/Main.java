package faang.school.godbless.BJS2_24470;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss("Java", 2);
        Player player1 = new Player("Robert");
        Player player2 = new Player("Sultan");
        Player player3 = new Player("Denis");
        Player player4 = new Player("Vlad");
        Player player5 = new Player("Mikhail");
        List<Player> players = List.of(player1, player2, player3, player4, player5);

        ExecutorService executor = Executors.newFixedThreadPool(boss.getMaxPlayers());
        players.forEach(player ->
                executor.execute(() -> player.startBattle(boss))
        );
        executor.shutdown();
        try {
            if (!executor.awaitTermination(50, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}
