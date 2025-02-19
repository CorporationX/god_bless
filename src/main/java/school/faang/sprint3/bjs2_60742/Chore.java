package school.faang.sprint3.bjs2_60742;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Chore implements Runnable {
    private final String choreName;

    public Chore(@NonNull String choreName) {
        if (choreName.isBlank()) {
            log.error("Название задачи пустое (или одни пробелы)");
            throw new IllegalArgumentException("Название задачи пустое (или одни пробелы)");
        }
        this.choreName = choreName;
    }

    @Override
    public void run() {
        try {
            log.info("{} выполняет задачу (этап 1): {}", Thread.currentThread().getName(), choreName);
            Thread.sleep(1000);
            log.info("{} выполняет задачу (этап 2): {}", Thread.currentThread().getName(), choreName);
            Thread.sleep(1000);
            log.info("{} выполняет задачу (этап 3): {}", Thread.currentThread().getName(), choreName);
            Thread.sleep(1000);
            log.info("{} выполнил задачу: {}", Thread.currentThread().getName(), choreName);
        } catch (InterruptedException e) {
            log.error("Задача: {} прервана {}", choreName, e.getMessage());
            Thread.currentThread().interrupt();
        }
    }
}
