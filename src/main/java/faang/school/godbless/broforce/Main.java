package faang.school.godbless.broforce;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        Game game = new Game();
        Bro firstBro = new Bro("first", 5);
        Bro secondBro = new Bro("second", 9);

        game.addBro(firstBro);
        game.addBro(secondBro);

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        for (int i = 0; i < game.getBros().size(); i++) {
            executorService.submit(() -> {
                while (firstBro.getLives() > 0 && secondBro.getLives() > 0) {
                    boolean isAnyoneDead = game.update();
                    System.out.println("Is anyone dead? " + isAnyoneDead);
                }
            });
        }
        executorService.shutdown();
    }
}
