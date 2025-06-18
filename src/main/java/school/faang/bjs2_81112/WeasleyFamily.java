package school.faang.bjs2_81112;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class WeasleyFamily {
    private static final int TIMEOUT = 10;
    private String[] chores =
            new String[]{"помыть посуду", "подмести пол", "постирать вещи", "полить цветы", "приготовить ужин"};

    public void doChores() {
        ExecutorService executor = Executors.newCachedThreadPool();

        for (String chore : chores) {
            executor.execute(new Chore(chore));
        }

        executor.shutdown();
        try {
            if (!executor.awaitTermination(TIMEOUT, TimeUnit.SECONDS)) {
                System.out.println("Не все задачи завершены в указанный период времени.");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Поток был прерван", e);
            executor.shutdownNow();
        }

        log.info("Все задачи выполнены");
    }
}
