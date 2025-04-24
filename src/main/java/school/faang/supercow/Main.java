package school.faang.supercow;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int TIME_OUT = 10000;

    public static void main(String[] args) {
        Boss boss = new Boss(3);

        ExecutorService service = Executors.newFixedThreadPool(7);
        service.execute(() -> new Player("Igor").doBattle(boss));
        service.execute(() -> new Player("Ilya").doBattle(boss));
        service.execute(() -> new Player("Kirill").doBattle(boss));
        service.execute(() -> new Player("Ivan").doBattle(boss));
        service.execute(() -> new Player("Vlad").doBattle(boss));
        service.execute(() -> new Player("Valeriy").doBattle(boss));
        service.execute(() -> new Player("Peter").doBattle(boss));

        service.shutdown();
        try {
            if (!service.awaitTermination(TIME_OUT, TimeUnit.MILLISECONDS)) {
                service.shutdownNow();
            } else {
                service.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Interrupted", e);
        }
    }
}
