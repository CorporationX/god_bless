package school.faang.bro_force.BJS2_61630;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

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
                    LOGGER.info("Is anyone dead? {}", game.update());
                }
            });
        }
        executorService.shutdown();
    }
}
