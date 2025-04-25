package school.faang.bro_force;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Game game = new Game();
        Bro firstBro = new Bro("Piter", 10, true);
        Bro secondBro = new Bro("Parker", 25, true);

        game.addBro(firstBro);
        game.addBro(secondBro);

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for (int i = 0; i < game.getBros().size(); i++) {
            executorService.submit(() -> {
                boolean random = Math.random() < 0.3;
                boolean random2 = Math.random() < 0.3;
                while (!game.updateGameState(random, random2)) {
                    random = Math.random() < 0.3;
                    random2 = Math.random() < 0.3;
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        System.out.println("Thread interrupted: " + Thread.currentThread().getName());
                        break;
                    }
                }
                System.out.println("Game over detected in thread: " + Thread.currentThread().getName());
            });
        }
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);
    }
}
