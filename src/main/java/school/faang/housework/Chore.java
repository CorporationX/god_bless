package school.faang.housework;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@Data
public class Chore implements Runnable {
    private String task;

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        log.info("Задача: {} выполняется потоком: {}\n ", task, threadName);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
