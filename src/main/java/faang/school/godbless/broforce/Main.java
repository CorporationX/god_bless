package faang.school.godbless.broforce;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        Bro bro1 = new Bro("Terminator", 7);
        Bro bro2 = new Bro("Robocop", 7);
        Bro bro3 = new Bro("Lucky", 3);
        Game game = new Game();
        game.addBro(bro1);
        game.addBro(bro2);
        game.addBro(bro3);
        ExecutorService executor = Executors.newFixedThreadPool(3);


        executor.submit(() -> {
            while (game.isRunning()) {
                boolean isStillRunning = game.update();
            }
        });

        executor.shutdown();
        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Everything is finished!");
    }
}
