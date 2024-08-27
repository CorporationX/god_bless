package faang.school.godbless.bigbangtheory;

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

        executor.submit(sheldonTask);
        executor.submit(leonardTask);
        executor.submit(howardTask);
        executor.submit(rajeshTask);

        executor.shutdown();

        try {
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                executor.shutdownNow();
                System.out.println("Задачи не были завершены вовремя. Прерывание выполнения.");
            } else {
                System.out.println("Все задачи завершены.");
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
            System.out.println("Основной поток был прерван. Задачи были прерваны.");
        }

    }
}

