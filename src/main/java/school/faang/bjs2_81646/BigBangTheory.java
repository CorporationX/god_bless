package school.faang.bjs2_81646;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class BigBangTheory {
    public static final int MAX_WAIT_MINUTES = 1;

    public static void main(String[] args) throws InterruptedException {
        String[] names = {"Шелдон", "Леонард", "Говард", "Лало"};
        String[] tasks = {"подготовка теории", "моделирование эксперимента",
                "разработка инструментов", "анализ данных"};

        ExecutorService executor = Executors.newFixedThreadPool(4);

        for (int i = 0; i < names.length; i++) {
            executor.submit(new Task(names[i], tasks[i]));
        }

        executor.shutdown();
        try {
            if (!executor.awaitTermination(MAX_WAIT_MINUTES, TimeUnit.MINUTES)) {
                log.info("Не все задачи завершены за {} минут. Завершаем принудительно...", MAX_WAIT_MINUTES);
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Ожидание завершения потоков прервано.");
            executor.shutdownNow();
        }
    }
}
