package faang.school.godbless.BroForce;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static faang.school.godbless.BroForce.Game.players;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        // List<Player> players = new ArrayList<>();
        players.add(new Player("Player1", 1));
        players.add(new Player("Player2", 2));
        players.add(new Player("Player3", 3));

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (Player player : players) {
            executorService.submit(() -> {
                try {
                    while (player.getLive() > 0)
                        // player.run();     //получается что-то страшное
                        game.update(player);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        executorService.shutdown();
        try {
            executorService.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Iгра окончена");
    }

}
