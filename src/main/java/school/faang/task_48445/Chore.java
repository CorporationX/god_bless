package school.faang.task_48445;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Chore implements Runnable {
    private static final int EXECUTION_TIME_IN_MILLIS = 3000;
    private final String chore;

    public Chore(String chore) {
        validateChore(chore);

        this.chore = chore;
    }

    @Override
    public void run() {
        try {
            log.info("Поток №{} выполняет задачу", Thread.currentThread().getName());
            Thread.sleep(EXECUTION_TIME_IN_MILLIS);
            log.info("Задача {} выполнена", chore);
        } catch (InterruptedException e) {
            log.error("Задача {} была прервана", chore, e);
        }
    }

    private static void validateChore(String chore) {
        if (chore == null || chore.isEmpty()) {
            throw new IllegalArgumentException("Chore can't be null or empty!");
        }
    }
}
