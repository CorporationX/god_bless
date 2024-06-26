package faang.school.godbless.module1.sprint3.task11;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final Random RANDOM = new Random();
    public static void main(String[] args) {
        Game game = new Game();
        Fighter first = new Fighter("Alan", RANDOM.nextInt(50,101), RANDOM.nextInt(50,101));
        Fighter second = new Fighter("Glen", RANDOM.nextInt(50,101), RANDOM.nextInt(50,101));
        ExecutorService service = Executors.newFixedThreadPool(2);

        do {
            if (first.isAlive() && second.isAlive()) {
                service.submit(() -> {
                    try {
                        game.rollAttack(first, second);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                });
            } else if (first.isAlive()) {
                game.update(second, first);
            } else {
                game.update(first, second);
            }
        } while (first.getLives() > 0 && second.getLives() > 0);
        service.shutdownNow();
    }


}
