package faang.school.godbless.basereception;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class App {
    @SneakyThrows
    public static void main(String[] args) {
        MilitaryBase baseA = new MilitaryBase("Base A");
        MilitaryBase baseB = new MilitaryBase("Base B");
        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.execute(baseA);
        executorService.execute(baseB);
        baseA.sendMessage(baseB, "Top secret message from Base A");
        baseB.sendMessage(baseA, "Reply from Base B");
        Thread.sleep(5000);
        baseA.stop();
        baseB.stop();
        shutdown(executorService);
    }

    private static void shutdown(ExecutorService executorService) {
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(10, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
                if (!executorService.awaitTermination(10, TimeUnit.SECONDS)) {
                    log.error("Executor did not terminate");
                }
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}