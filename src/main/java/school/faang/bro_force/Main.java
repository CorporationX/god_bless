package school.faang.bro_force;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        Bro broSumkin = new Bro("Сёма Сумкин", 5, true);
        Bro broFedor = new Bro("Дядя Федор", 5, true);
        Bro broPendalf = new Bro("Пендальф", 5, true);
        Game game = new Game(new ArrayList<>(List.of(broSumkin, broPendalf, broFedor)));
        ExecutorService service = Executors.newFixedThreadPool(3);

        for (int i = 0; i < game.getBros().size(); i++) {
            int finalI = i;
            service.submit(() -> {
                while (game.isSomeoneAlive()) {
                    boolean isLifeMinus = Math.random() < 0.3;
                    boolean isAddPoints = Math.random() < 0.4;

                    game.update(isAddPoints, isLifeMinus, game.getBros().get(finalI));
                }
            });
        }

        service.shutdown();

        try {
            if (!service.awaitTermination(1, TimeUnit.MINUTES)) {
                service.shutdownNow();
            }
        } catch (InterruptedException e) {
            service.shutdownNow();
        }

    }
}
