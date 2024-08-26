package faang.school.godbless.BJS2_24188;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        Game game = new Game();
        Bro firstBro = new Bro("Terminator", 5, true);
        Bro secondBro = new Bro("Sara Conor", 9, true);

        game.addBro(firstBro);
        game.addBro(secondBro);

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (int i = 0; i < game.getBros().size(); i++) {
            executorService.submit(() -> {
                while (firstBro.getLives() > 0 && secondBro.getLives() > 0) {
                    boolean isAnyoneDead = game.update();
                    System.out.println("Is anyone dead? " + isAnyoneDead);
                }
            });
        }

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(800, TimeUnit.MILLISECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }
}
