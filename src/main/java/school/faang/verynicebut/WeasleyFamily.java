package school.faang.verynicebut;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class WeasleyFamily {
    private static final String[] chores = {"помыть посуду", "подмести пол", "приготовить ужин",
            "постирать одежду", "покормить Рона"};
    private static final Integer TIMEOUT_SECONDS = 5;

    public static void main(String[] args) {

        ExecutorService service = Executors.newCachedThreadPool();
        for (String chore : chores) {
            service.submit(new Chore(chore));
        }
        service.shutdown();

        try {
            if (!service.awaitTermination(TIMEOUT_SECONDS, TimeUnit.SECONDS)) {
                service.shutdownNow();
                log.info("Задачи не успели выполнится за {} секунд", TIMEOUT_SECONDS);
            }
        } catch (InterruptedException e) {
            log.warn(e.getMessage());
            throw new RuntimeException();
        }
        log.info("Все задачи выполнились");
    }
}
