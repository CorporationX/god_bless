package school.faang.bjs282464;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        log.info("Тест с Future + CompletableFuture");
        long startTime = System.currentTimeMillis();

        MasterCardService service = new MasterCardService();
        service.doAll();

        long endTime = System.currentTimeMillis();
        log.info("Общее время выполнения: {} мс", (endTime - startTime));

        log.info("Тест только с CompletableFuture");
        startTime = System.currentTimeMillis();

        MasterCardService service2 = new MasterCardService();
        service2.doAllWithCompletableFuture();

        endTime = System.currentTimeMillis();
        log.info("Общее время выполнения: {} мс", (endTime - startTime));
    }
}
