package faang.school.godbless.BroForce;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        Player valera = new Player("valera",5,0);
        Player gena = new Player("gena",4,0);

        game.addPlayer(valera);
        game.addPlayer(gena);

        ExecutorService executor = Executors.newFixedThreadPool(game.getPlayers().size());

        for (int i = 0; i < game.getPlayers().size(); i++) {
            executor.execute(() -> {
                while (valera.getLives() > 0 && gena.getLives() > 0) {
                    boolean b = game.update();
                    System.out.println("кто то вмер? " + b);
                }
            });
        }

        executor.shutdown();
        try {
            if (!executor.awaitTermination(1, TimeUnit.HOURS)) {
                executor.shutdownNow();
            }
            System.out.println("закончил");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
