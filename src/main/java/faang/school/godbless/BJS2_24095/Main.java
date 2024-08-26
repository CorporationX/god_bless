package faang.school.godbless.BJS2_24095;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        Bro bro1 = new Bro(10, "Konan");
        Bro bro2 = new Bro(15, "Superman");
        Bro bro3 = new Bro(14, "Batman");
        Bro bro4 = new Bro(9, "Flash");
        Bro bro5 = new Bro(21, "Somebody");
        game.addBro(bro1);
        game.addBro(bro2);
        game.addBro(bro3);
        game.addBro(bro4);
        game.addBro(bro5);
        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (int i = 0; i < game.getBros().size(); i++) {
            executor.submit(() -> {
                while (!game.anyOneDead()) {
                    game.update();
                }
            });
        }
        try {
            executor.shutdown();
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
