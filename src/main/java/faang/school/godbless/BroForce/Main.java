package faang.school.godbless.BroForce;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        Game game = new Game(0,10);

        ExecutorService executor = Executors.newFixedThreadPool(10);
        executor.execute(() -> {
            for (int i = 0; i < 10; i++) {
                game.update();
                System.out.println("Результат: " + game.getScore() + ", Жизнь: " + game.getLives());
            }
            executor.shutdown();
        });


    }
}
