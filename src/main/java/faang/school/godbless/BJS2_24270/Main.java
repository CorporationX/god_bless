package faang.school.godbless.BJS2_24270;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();

        Bro firstBro = new Bro("Terminator", 7, true);
        Bro secondBro = new Bro("Sara Conor", 9, true);

        game.addBro(firstBro);
        game.addBro(secondBro);

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        for (int i = 0; i < game.getBros().size(); i++) {
            executorService.submit(() -> {
                while (firstBro.getLives() > 0 && secondBro.getLives() > 0) {
                    System.out.println("Мертв ли кто? " + game.update());
                }
            });
        }
        executorService.shutdown();
    }
}
