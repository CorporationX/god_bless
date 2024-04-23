package faang.school.godbless.BroForce;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        List<Bro> bros = getBros();
        Game game = new Game();
        bros.forEach(game::addBro);

        ExecutorService pool = Executors.newFixedThreadPool(bros.size());
        for (int i = 0; i < bros.size(); i++) {
            pool.execute(() -> {
                while (game.update());
            });
        }
        pool.shutdown();

        try {
            while (!pool.awaitTermination(10, TimeUnit.SECONDS)) ;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static List<Bro> getBros() {
        return List.of(
                new Bro("Theo", 3),
                new Bro("Ramos", 5),
                new Bro("Bonucci", 4),
                new Bro("Saliba", 4),
                new Bro("Ake", 3)
        );
    }
}
