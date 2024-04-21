package faang.school.godbless.the_big_bang;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
        public static void main(String[] args) {
            ExecutorService executorService = Executors.newFixedThreadPool(4);
            Task sheldonTask = new Task("Шелдон", "подготовка теории");
            Task leonardTask = new Task("Леонард", "моделирование эксперимента");
            Task howardTask = new Task("Говард", "разработка инструментов");
            Task rajeshTask = new Task("Раджеш", "анализ данных");
            executorService.execute(sheldonTask);
            executorService.execute(leonardTask);
            executorService.execute(howardTask);
            executorService.execute(rajeshTask);

            executorService.shutdown();

            try {
                if (!executorService.awaitTermination(5, TimeUnit.SECONDS)) {
                    executorService.shutdownNow();
                }
            } catch (InterruptedException e) {
                executorService.shutdownNow();
                Thread.currentThread().interrupt();
            }
            System.out.println("Все задания выполнены");
        }
    }
