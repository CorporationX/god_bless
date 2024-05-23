package faang.school.godbless.multithreading_synchronization.BJS2_6507;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final int THREAD_COUNT = 3;

    public static void main(String[] args) throws InterruptedException {
        Player player1 = new Player("Player 1", 0, 3, true);
        Player player2 = new Player("Player 2", 0, 4, true);
        Player player3 = new Player("Player 3", 0, 5, true);

        Game game = new Game();

        game.addPlayer(player1);
        game.addPlayer(player2);
        game.addPlayer(player3);

        ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);

        List<Player> playerList = game.getPlayers();

        while (!game.isFinished()) {
            for (int index = 0; index < playerList.size(); index++) {
                executor.execute(() -> {
                    int playerIndex = new Random().nextInt(playerList.size());
                    Player player = playerList.get(playerIndex);
                    game.update(player,Math.random() > 0.5, Math.random() > 0.5);
                });
            }

            Thread.sleep(1000);
        }

        executor.shutdown();
    }
}
