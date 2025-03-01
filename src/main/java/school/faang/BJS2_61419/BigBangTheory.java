package school.faang.BJS2_61419;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j

public class BigBangTheory {

    private static final int AWAIT_TERMINATION_TIMEOUT_MINUTES = 5;

    public static void main(String[] args) {
        log.info("Начало работы  программы: ");

        ExecutorService executor = Executors.newFixedThreadPool(5);

        Task sheldonTask = new Task("Шелдон", "подготовка теории");
        Task leonardTask = new Task("Леонард", "моделирование эксперимента");
        Task howardTask = new Task("Говард", "разработка инструментов");
        Task rajeshTask = new Task("Раджеш", "анализ данных");

        executor.execute(sheldonTask);
        executor.execute(leonardTask);
        executor.execute(howardTask);
        executor.execute(rajeshTask);

        executor.shutdown();

        try {
            if (!executor.awaitTermination(AWAIT_TERMINATION_TIMEOUT_MINUTES, TimeUnit.MINUTES)) {
                log.warn("Задачи не завершились за 5 минут, принудительно останавливаем...");
                executor.shutdownNow();
            } else {
                log.info("Все задачи успешно завершены.");
            }
        } catch (InterruptedException e) {
            log.warn("Поток был прерван");
            executor.shutdownNow();
        }
        log.info("Завершение работы программы");
    }
}