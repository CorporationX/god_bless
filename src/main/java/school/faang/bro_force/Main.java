package school.faang.bro_force;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Game game = new Game();
        Bro firstBro = new Bro("Piter", 10);
        Bro secondBro = new Bro("Parker", 25);

        game.addBro(firstBro);
        game.addBro(secondBro);

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for (int i = 0; i < game.getBros().size(); i++) {
            executorService.submit(() -> {
                boolean randomValueBro1 = Math.random() < 0.3;
                boolean randomValueBro2 = Math.random() < 0.3;
                while (!game.updateGameState(randomValueBro1, randomValueBro2)) {
                    randomValueBro1 = Math.random() < 0.3;
                    randomValueBro2 = Math.random() < 0.3;
                    try {
                        TimeUnit.MILLISECONDS.sleep(100);
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
        try {
            if (!executorService.awaitTermination(5, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }
}
