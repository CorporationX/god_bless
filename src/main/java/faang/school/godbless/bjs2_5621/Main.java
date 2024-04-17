package faang.school.godbless.bjs2_5621;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {


        Player ivan = new Player("Ivan", 0, 3, true);
        Player petr = new Player("Petr", 0, 3, true);
        Player katya = new Player("Katya", 0, 3, true);

        Game game = new Game();
        game.addPlayer(ivan);
        game.addPlayer(petr);
        game.addPlayer(katya);

        ExecutorService executor = Executors.newFixedThreadPool(3);

        int iteration = 1;
        while (iteration < 20 && !game.getPlayers().isEmpty()) {
            System.out.println("\nIteration: " + iteration);
            for (Player ignored : game.getPlayers()) {
                executor.execute(() -> {
                    if (!game.getPlayers().isEmpty()) {
                        game.update();
                    }
                });
            }
            iteration++;
            Thread.sleep(2000);
        }
        executor.shutdown();

        try {
            while (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
