package faang.school.godbless.BJS2_24060;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        List<Player> players = getPlayers();
        ExecutorService executor = Executors.newFixedThreadPool(players.size());
        Game game = new Game(players);

        players.forEach(player ->
                executor.execute(game::update));

        executor.shutdown();
        try {
            if (!executor.awaitTermination(30, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }

    private static List<Player> getPlayers() {
        return List.of(
                new Player("John", 10),
                new Player("Robert", 10),
                new Player("Mikhail", 10)
        );
    }
}
