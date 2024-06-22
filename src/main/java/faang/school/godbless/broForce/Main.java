package faang.school.godbless.broForce;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static List<Bro> bros = List.of(new Bro("Oleg", 1, true),
            new Bro("Sasha", 6, false),
            new Bro("Igor", 10, true));

    private static Game game = new Game();

    public static void main(String[] args) {
        for (Bro bro : bros) {
            game.addBro(bro);
        }

        ExecutorService executorService = Executors.newFixedThreadPool(1);
        for (int i = 0; i < bros.size(); i++) {
            Bro bro = game.getBros().get(i);

            executorService.submit(() -> {
                while (bro.getLives() != 0) {
                    game.update();
                }
            });
        }
        executorService.shutdown();
    }
}
