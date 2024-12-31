package school.faang.sprint_4.task_51080;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class App {
    public static final int DELAY = 5000;

    public static void main(String[] args) throws Exception {
        MilitaryBase volga = new MilitaryBase("Волга");
        MilitaryBase don = new MilitaryBase("Дон");

        ExecutorService executor = Executors.newCachedThreadPool();

        List<CompletableFuture<Void>> futures = new ArrayList<>();
        futures.add(CompletableFuture.runAsync(volga, executor));
        futures.add(CompletableFuture.runAsync(don, executor));
        futures.add(CompletableFuture.runAsync(() -> {
            try {
                sendAndStop(volga, don);
            } catch (Exception e) {
                log.error("Произошла ошибка во время выпаленная задачи: {}", e.getMessage());
            }
        },  executor));

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .whenComplete((result, throwable) -> {
                    if (throwable == null) {
                        log.info("Все задачи завершены");
                        executor.shutdown();
                    } else {
                        log.error("Произошла ошибка при завершении задачи: {}", throwable.getMessage());
                    }
                }).join();
    }

    private static void sendAndStop(MilitaryBase volga, MilitaryBase don) throws Exception {
        volga.sendMessage(don, "Сообщение от базы 1");
        don.sendMessage(volga, "Ответ от базы 2");
        try {
            Thread.sleep(DELAY);
        } catch (InterruptedException e) {
            log.error("Произошла ошибка во время ожидания: {}", e.getMessage());
        }
        volga.stop();
        don.stop();
    }
}
