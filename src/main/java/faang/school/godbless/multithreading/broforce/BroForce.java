package faang.school.godbless.multithreading.broforce;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BroForce {
    public static void main(String[] args) throws InterruptedException {
        Game game = new Game();
        ExecutorService service = Executors.newFixedThreadPool(2);
        for (int i = 0; i <= 10; i++) {
            service.submit(game::update);
        }
        service.shutdown();
        service.awaitTermination(10, TimeUnit.MINUTES);
        System.out.println("Final score: " + game.getScore());
        System.out.println("Remaining lives: " + game.getLives());
    }
}

