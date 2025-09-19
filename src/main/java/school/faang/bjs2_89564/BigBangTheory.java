package school.faang.bjs2_89564;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class BigBangTheory {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(4);

        Task sheldon = new Task("Шелдон", "подготовка теории");
        Task leonard = new Task("Леонард", "моделирование эксперимента");
        Task howard = new Task("Говард", "разработка инструментов");
        Task rajesh = new Task("Раджеш", "анализ данных");

        executor.submit(sheldon);
        executor.submit(leonard);
        executor.submit(howard);
        executor.submit(rajesh);

        executor.shutdown();
        try {
            if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }

        log.info("Все задачи выполнены, пул потоков остановлен.");
    }
}