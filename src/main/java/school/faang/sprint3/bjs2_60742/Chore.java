package school.faang.sprint3.bjs2_60742;

import lombok.Getter;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class Chore implements Runnable {
    private final String choreName;
    private final int sleepTime = 1000;

    public Chore(@NonNull String choreName) {
        if (choreName.isBlank()) {
            log.error("Название задачи пустое (или одни пробелы)");
            throw new IllegalArgumentException("Название задачи пустое (или одни пробелы)");
        }
        this.choreName = choreName;
    }

    @Override
    public void run() {
        String[] logMessages = {
                "{} выполняет задачу (этап 1): {}",
                "{} выполняет задачу (этап 2): {}",
                "{} выполняет задачу (этап 3): {}",
                "{} выполнил задачу: {}"
        };

        try {
            for (String message : logMessages) {
                log.info(message, Thread.currentThread().getName(), choreName);
                Thread.sleep(getSleepTime());
            }
        } catch (InterruptedException e) {
            log.error("Задача: {} прервана {}", choreName, e.getMessage());
            Thread.currentThread().interrupt();
        }
    }
}
