package faang.school.godbless.supercow2972;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Game {
    public static void main(String[] args) throws InterruptedException {
        List<Player> players = createPlayersList();
        Boss ornsteinAndSmough = new Boss(3);
        ExecutorService executor = Executors.newFixedThreadPool(5);

        for (Player player : players) {
            executor.execute(() -> {
                try {
                    ornsteinAndSmough.joinBattle(player);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        executor.shutdown();
        executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        System.out.println("All players left the boss. Wounded but not broken!");
    }

    private static List<Player> createPlayersList() {
        return new ArrayList<>(List.of(
                new Player("Doodledooh"),
                new Player("Booblebooh"),
                new Player("$_PrOgAmEr_$"),
                new Player("DEMON_SLAYER_2015"),
                new Player("Player1052236")));
    }
}
