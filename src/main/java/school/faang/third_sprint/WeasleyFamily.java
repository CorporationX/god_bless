package school.faang.third_sprint;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class WeasleyFamily {
    private static final String[] CHORES = {"помыть посуду", "подмести пол", "приготовить ужин", "погладить кошку"};
    private static final ExecutorService EXECUTOR = Executors.newCachedThreadPool();

    public static void main(String[] args) {
        for (String chore : CHORES) {
            EXECUTOR.execute(new Chore(chore));
        }
        EXECUTOR.shutdown();

        try {
            if (!EXECUTOR.awaitTermination(5, TimeUnit.MINUTES)) {
                log.error("Не все задачи были выполнены вовремя");
                EXECUTOR.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("awaitTermination был прерван");
            EXECUTOR.shutdownNow();
        }
    }
}
