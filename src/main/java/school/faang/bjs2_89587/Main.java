package school.faang.bjs2_89587;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int AWAIT_TIME = 1;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        WeasleyFamily weasleyFamily = new WeasleyFamily();
        String[] chores = weasleyFamily.getChores();

        for (String chore : chores) {
            executor.submit(new Chore(chore));
        }
        executor.shutdown();
        try {
            if (!executor.awaitTermination(AWAIT_TIME, TimeUnit.MINUTES)) {
                log.info("Не все задачи завершины за {} минут, принудительное закрытие пула потоков.", AWAIT_TIME);
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Ожидание завершения потоков прервано.");
            executor.shutdownNow();
        }
        System.out.println("Все задачи выполнены.");
    }
}
