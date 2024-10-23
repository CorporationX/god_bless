package school.faangSprint3.t13;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(4);

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
            if (!executor.awaitTermination(5, TimeUnit.MINUTES)) {
                System.out.println("Задачи не завершились за 5 минут, принудительно останавливаем...");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            System.out.println("Основной поток был прерван");
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}