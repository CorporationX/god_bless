package faang.school.godbless.supercow;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        Boss boss = new Boss(2);

        List<Player> players = List.of(new Player("player1"), new Player("player2"),
                new Player("player3"), new Player("player4"), new Player("player5"));

        players.stream().forEach(player -> {
            executorService.execute(() -> {
                try {
                    player.startBattle(boss);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        });
        executorService.shutdown();
    }
}