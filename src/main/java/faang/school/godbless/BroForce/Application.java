package faang.school.godbless.BroForce;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Application {
    public static void main(String[] args) {
        Bro bro1 = new Bro("RealBro", 50, 0);
        Bro bro2 = new Bro("NeBro", 50, 0);
        Bro bro3 = new Bro("SuperBro", 50, 0);
        Bro bro4 = new Bro("TruBro", 50, 0);
        Game game = new Game(List.of(bro1, bro2, bro3, bro4));
        ExecutorService executorService = Executors.newFixedThreadPool(game.getBros().size());

        executorService.execute(() -> {
            int i = 0;
            while (game.isGameIsNotOver()) {
                game.update(i++);
            }
        });

        executorService.shutdown();
    }
}
