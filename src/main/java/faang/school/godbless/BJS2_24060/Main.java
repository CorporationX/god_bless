package faang.school.godbless.BJS2_24060;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        Player player1 = new Player("Robert", 3);
        Player player2 = new Player("John", 4);
        Player player3 = new Player("Mary", 5);
        Player player4 = new Player("Sultan", 4);
        Player player5 = new Player("Michael", 5);
        Player player6 = new Player("John", 6);
        Player player7 = new Player("John", 7);
        Player player8 = new Player("John", 8);
        Player player9 = new Player("John", 9);
        Player player10 = new Player("John", 10);
        List<Player> players = List.of(player1, player2, player3, player4, player5, player6, player7, player8, player9, player10);

        ExecutorService executor = Executors.newCachedThreadPool();
        Game game = new Game(executor);

        Runnable gameProcess = () -> players.forEach(player -> {
            while (player.getLives() > 0) {
                for (int i = 0; i < player.getDurationLife(); i++) {
                    if (Thread.currentThread().isInterrupted()) {
                        System.out.println("Thread interrupted during update: " + player.getName());
                        return;
                    }
                    game.update();
                }

                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("Thread interrupted during the dying: " + player.getName());
                    return;
                }
                game.die(player);
            }
        });
        executor.execute(gameProcess);

        executor.shutdown();
        try {
            if (!executor.awaitTermination(2, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }

        System.out.println(GeneralStatistics.getScore() + " " + GeneralStatistics.getLostLives());
    }
}
