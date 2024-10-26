package school.faang.sprint3.broforce;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        Bro bro1 = new Bro("Terminator ", 5, 0, true);
        Bro bro2 = new Bro("Sare ", 9, 0, true);
        game.addBro(bro1);
        game.addBro(bro2);

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < game.getBros().size(); i++) {
            executorService.submit(() -> {
                while (bro1.getLives() > 0 && bro2.getLives() > 0) {
                    boolean gameIsRunning = game.update();
                    System.out.println("Умер ? " + gameIsRunning);
                }
            });
        }
        executorService.shutdown();
    }
}
