package faang.school.godbless.bro_force;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        Player player1 = new Player("Axe", 10);
        Player player2 = new Player("Drow", 4);
        Player player3 = new Player("Sniper", 5);
        Player player4 = new Player("Centaur", 15);
        Player player5 = new Player("Pudge", 20);

        game.addPlayer(player1);
        game.addPlayer(player2);
        game.addPlayer(player3);
        game.addPlayer(player4);
        game.addPlayer(player5);

        ExecutorService poolThreads = Executors.newFixedThreadPool(3);

        for (int i = 0; i < game.getPlayers().size(); i++) {
            poolThreads.submit(() -> {
                while (!game.anyOneDead()) {
                    game.update();
                }
            });
        }

        try {
            poolThreads.shutdown();
            if (!poolThreads.awaitTermination(60, TimeUnit.SECONDS)) {
                poolThreads.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
