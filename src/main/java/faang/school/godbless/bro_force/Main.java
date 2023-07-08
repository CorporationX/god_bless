package faang.school.godbless.bro_force;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        Bro firstBro = new Bro("Terminator", 5,true);
        Bro secondBro = new Bro("Sara Conor", 9,true);

        game.addBro(firstBro);
        game.addBro(secondBro);

        ExecutorService executor = Executors.newFixedThreadPool(2);

            for (int i = 0; i <= game.getBros().size(); i++) {
                executor.submit(() -> {
                    while (firstBro.getLives() > 0 && secondBro.getLives() > 0) {
                        boolean gameIsRunning = game.update();
                        System.out.println("Is anyone alive? " + gameIsRunning);
                    }
                });
            }
    }
}
