package school.faang.bjs2_90138;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {

        Game game = new Game();

        Bro bro1 = new Bro();
        bro1.setName("Indiana Jones");
        Bro bro2 = new Bro();
        bro2.setName("Commando");
        Bro bro3 = new Bro();
        bro3.setName("John Wick");
        Bro bro4 = new Bro();
        bro4.setName("Terminator");

        game.addBro(bro1);
        game.addBro(bro2);
        game.addBro(bro3);
        game.addBro(bro4);

        ExecutorService executorService = Executors.newFixedThreadPool(game.getBros().size());

        for (int i = 0; i < game.getBros().size(); i++) {
            executorService.submit(() -> {
                while (game.getBros().stream().allMatch(bro -> bro.getLives() > 0)) {
                    boolean isAnyoneDead = game.update();
                    System.out.println("Is anyone dead? " + isAnyoneDead);
                }
            });
        }
        executorService.shutdown();
    }
}