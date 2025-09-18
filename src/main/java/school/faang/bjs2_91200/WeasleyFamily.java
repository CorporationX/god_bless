package school.faang.bjs2_91200;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
@Getter
public class WeasleyFamily {
    private static final int MAX_WAIT_MINUTE = 1;
    private List<String> chores = new ArrayList<>();

    public void doTask() {
        ExecutorService executors = Executors.newCachedThreadPool();
        for (int i = 0; i < chores.size(); i++) {
            Chore task = new Chore(chores.get(i));
            executors.submit(task);
        }
        executors.shutdown();
        try {
            if (!executors.awaitTermination(MAX_WAIT_MINUTE, TimeUnit.MINUTES)) {
                log.info("Не все задачи завершены за {} минут. Завершаем принудительно", MAX_WAIT_MINUTE);
                executors.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Ожидание завершения потоков прервано.");
            executors.shutdownNow();
        }
    }

    public void addTask(String task) {
        if (task == null && task.isBlank()) {
            log.info("Task not be null or have only space");
            throw new IllegalArgumentException("Задача не может быть пустой!");
        }
        chores.add(task);
    }
}
