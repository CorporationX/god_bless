package faang.school.godbless.BJS2_24224;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    private final static List<Player> players = new ArrayList<>();

    public static void main(String[] args) {

        players.add(new Player("Kirito", 10));
        players.add(new Player("Asuna", 20));
        players.add(new Player("Klein", 30));

        Game game = new Game();

        ExecutorService executorService = Executors.newFixedThreadPool(players.size());

        for (Player player : players) {
            executorService.execute(() -> {
                while (player.getLives() > 0) {
                    game.update(player);
                }
            });
        }
        executorService.shutdown();

        try {
            if (executorService.awaitTermination(5, TimeUnit.MINUTES)) {
                System.out.println("Game ended total score - " + game.getScore() + ", lives - " + game.getLives());
            } else {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
