package school.faang.Multithreading.sprint_3.BroForce;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        Game game = new Game(0, 0);
        Player witch = new Player("Witch");
        Player archer = new Player("Лучник");
        Player swordsman = new Player("Мечник");
        List<Player> players = Arrays.asList(witch, archer, swordsman);

        ExecutorService executorService = Executors.newCachedThreadPool();

        for (Player player : players) {
            game.addPlayer(player);
        }

        executorService.execute(() -> {
            for (Player player : players) {
                for (int i = 0; i < 5; i++) {
                    player.earnScorePlayer(game);
                }
            }
            witch.earnScorePlayer(game);
            System.out.println();
        });

        for (Player player : players) {
            executorService.execute(() -> player.diePlayer(game));
        }

        executorService.execute(game::update);
        executorService.shutdown();
    }
}
