package faang.school.godbless.BroForce;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        List<Player> players = new ArrayList<>();
        players.add(new Player("Player1", 5));
        players.add(new Player("Player2", 5));
        players.add(new Player("Player3", 3));

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for (Player player : players) {
            executorService.submit(() -> {
                while (player.getLive()>0)
                        game.update(player);
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
