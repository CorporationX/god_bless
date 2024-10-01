package faang.school.godbless.ThirdSprint.BJS2_24455;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        Bro firstBro = new Bro("AAA", 3, true);
        Bro secondBro = new Bro("BBB", 4, true);

        game.getBros().add(firstBro);
        game.getBros().add(secondBro);

        ExecutorService service = Executors.newFixedThreadPool(game.getBros().size());

        service.execute(() -> {
            while (firstBro.getLives() != 0 && secondBro.getLives() != 0) {
                game.update();
            }
        });
        service.shutdown();
    }
}
