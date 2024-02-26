package faang.school.godbless.broforce;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Game game = new Game();
        Bro bro1 = new Bro("Bro 1");
        Bro bro2 = new Bro("Bro 2");
        game.addBro(bro1);
        game.addBro(bro2);
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(() -> {
            while (!game.isOver()) {
                game.update();
            }
        });
        executorService.shutdown();
        executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);
    }
}
