package school.faang.bjs2_92220;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Music {
    private static final int THREAD_COUNT = 4;
    private static final int MAX_AWAIT_TIME_MINUTE = 1;

    public static void main(String[] args) {
        Player player = new Player("ATL");
        List<Runnable> taskThread = List.of(
                () -> player.play(), () -> player.pause(), () -> player.skip(), () -> player.previous());
        ExecutorService execute = Executors.newFixedThreadPool(THREAD_COUNT);
        for (Runnable runnable : taskThread) {
            execute.submit(runnable);
        }
        execute.shutdown();
        try {
            if (!execute.awaitTermination(MAX_AWAIT_TIME_MINUTE, TimeUnit.MINUTES)) {
                log.info("Потоки не успели закончить работу за {} - минут. Останавливаем потоки",
                        MAX_AWAIT_TIME_MINUTE);
                execute.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.info("Попытка ожидания потоков привела к исключению. Останавливаем потоки");
            execute.shutdownNow();
        }
    }

}
