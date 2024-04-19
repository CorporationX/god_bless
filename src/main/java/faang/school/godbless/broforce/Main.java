package faang.school.godbless.broforce;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {

        Game game = new Game();
        Player terminator = new Player("terminator", 5, true);
        Player saraConor = new Player("Sara Conor", 9, true);
        game.addPlayer(saraConor);
        game.addPlayer(terminator);

        ExecutorService executor = Executors.newFixedThreadPool(3);
        for (int i = 0; i < game.getPlayers().size(); i++) {
            executor.execute(() -> {
                while (terminator.getLives() > 0 && saraConor.getLives() > 0) {
                    boolean gameIsRunning = game.update();
                    System.out.println("Is anyone dead? " + gameIsRunning);
                }
            });
        }

        executor.shutdown();
    }
}
