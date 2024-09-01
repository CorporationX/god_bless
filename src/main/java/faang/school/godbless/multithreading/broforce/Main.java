package faang.school.godbless.multithreading.broforce;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        Game broForce = new Game(0, 0);

        Player player1 = new Player("biba", 10);
        Player player2 = new Player("boba", 6);

        ExecutorService service = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 2; i++) {
            service.submit(() -> {
               while(player1.getLives() > 0 && player2.getLives() > 0)
                   broForce.update(player1, player2);
            });
        }

        service.shutdown();
    }

}
