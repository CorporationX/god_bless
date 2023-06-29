package faang.school.godbless.kxnvg.broforce;

import lombok.SneakyThrows;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class GameStarter {

    @SneakyThrows
    public static void main(String[] args) {
        Game game = new Game();
        Callable<Boolean> gameRunner1 = () -> { return game.update(true); };
        Callable<Boolean> gameRunner2 = () -> { return game.update(true); };
        Callable<Boolean> gameRunner3 = () -> { return game.update(false); };


        ExecutorService service = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 5; i++) {
            service.submit(gameRunner1);
            service.submit(gameRunner2);
            Future<Boolean> future = service.submit(gameRunner3);
            if (!future.get()) {
                break;
            }
        }
        service.shutdown();
    }
}
