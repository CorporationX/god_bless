package faang.school.godbless.BJS2_3249;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int MULTIPLY_PLAYERS = 100;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        Game game = new Game();
        List<Player> players = new ArrayList<>();
        for (int i = 0; i < MULTIPLY_PLAYERS; i++) {
            players.add(new Player("A", 10));
            players.add(new Player("B", 10));
            players.add(new Player("C", 10));
            players.add(new Player("D", 10));
            players.add(new Player("F", 10));
        }
        players.forEach((player -> executorService.execute(() -> {
            boolean isAlive = true;
            while (isAlive) {
                isAlive = game.update(player);
            }
        })));
        executorService.shutdown();
        try {
            if (executorService.awaitTermination(1000, TimeUnit.MILLISECONDS)) {
                System.out.println("Game finished");
            } else {
                executorService.shutdownNow();
                System.out.println("Game not finished");
            }
        } catch (InterruptedException e) {
            System.out.println("Game not finished: InterruptedException");
            executorService.shutdownNow();
        }
    }
}
