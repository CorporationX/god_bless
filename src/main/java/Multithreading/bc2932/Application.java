package Multithreading.bc2932;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Application {
    public static void main(String[] args) {
        Game game = new Game();

        Bro sarah = new Bro("Sarah", 10, true);
        Bro terminator = new Bro("Terminator", 10, true);

        game.addBro(sarah);
        game.addBro(terminator);

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for (int i = 0; i < game.bros.size(); i++) {
            executorService.execute(() -> {
                while (sarah.getLives() > 0 && terminator.getLives() > 0) {
                    boolean isAnyoneDead = game.update();
                    System.out.println("Is anyone dead: " + isAnyoneDead);
                }
            });
        }
        executorService.shutdown();
    }
}
