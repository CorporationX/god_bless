package faang.school.godbless;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FinalBattle {
    public static void main(String[] args) {
        Game game = new Game();

        Bro first = new Bro("Tyson", 0, 9, true);
        Bro second = new Bro("Ali", 0, 7, true);

        game.addBro(first);
        game.addBro(second);

        ExecutorService executor = Executors.newFixedThreadPool(2);

        for (Bro bro : game.bros) {
            executor.submit(() -> {
                while(first.getLives() > 0 && second.getLives() > 0) {
                    boolean isDead = game.update();
                    System.out.println("Is anyone dead? " + isDead);
                    }
                }
            );
        }
        executor.shutdown();
    }
}
