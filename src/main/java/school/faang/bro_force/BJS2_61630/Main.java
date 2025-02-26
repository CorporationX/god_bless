package school.faang.bro_force.BJS2_61630;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        Game game = new Game();

        Bro bob = new Bro("Bob", 5);
        Bro robin = new Bro("Robin", 7);

        game.addBro(bob);
        game.addBro(robin);

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < game.getBros().size(); i++) {
            executorService.submit(() -> {
                while (bob.getLives() > 0 && robin.getLives() > 0) {
                    game.update();
                }
            });
        }
        executorService.shutdown();
    }
}
