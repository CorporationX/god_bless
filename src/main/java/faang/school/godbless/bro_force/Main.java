package faang.school.godbless.bro_force;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    private static final int THREAD_COUNT = 2;

    public static void main(String[] args) {
        Game game = new Game();

        Bro varya = new Bro("Varya", 5);
        game.addBro(varya);
        Bro anna = new Bro("Anna", 7);
        game.addBro(anna);

        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_COUNT);
        for (int i = 0; i < THREAD_COUNT; i++) {
            executorService.submit(() -> {
                while (!varya.isDied() && !anna.isDied()) {
                    boolean gameIsRunning = game.update();
                    System.out.println("Кто-то умер? - " +  gameIsRunning);
                }
            });
        }

        executorService.shutdown();

        try {
            executorService.awaitTermination(3, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }
}
