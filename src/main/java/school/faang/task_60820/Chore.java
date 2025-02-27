package school.faang.task_60820;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@RequiredArgsConstructor
public class Chore implements Runnable {
    private static final int MIN_DURATION = 1_000;
    private static final int MAX_DURATION = 3_000;

    private final String title;

    @Override
    public void run() {
        final String threadName = Thread.currentThread().getName();
        final long threadDuration = ThreadLocalRandom.current().nextLong(MIN_DURATION, MAX_DURATION);

        try {
            log.info("Поток: {}, Задача: {} (~{} ms), Статус: В работе", threadName, title, threadDuration);
            Thread.sleep(threadDuration);
            log.info("Поток: {}, Задача: {}, Статус: Выполнено!", threadName, title);
        } catch (InterruptedException e) {
            log.warn("Задача: {}, Статус: Прервана", title);
            Thread.currentThread().interrupt();
        }
    }
}
