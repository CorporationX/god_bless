package school.faang.BJS2_60733;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Getter
@RequiredArgsConstructor
@Slf4j
public class Chore implements Runnable {

    private static final long TASK_DURATION = 5000;

    @NonNull
    private final String chore;

    @Override
    public void run() {
        try {
            log.info("Поток {} выполняет задачу '{}'\n", Thread.currentThread().getName(), getChore());
            Thread.sleep(TASK_DURATION);
            log.info("Задача '{}' завершена\n", getChore());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.info("Задача прервана: {}\n", getChore());
            return;
        }
    }
}
