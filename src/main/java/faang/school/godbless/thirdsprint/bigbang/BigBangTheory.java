package faang.school.godbless.thirdsprint.bigbang;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        List<Task> tasks = List.of(
                new Task("Шелдон", "подготовка теории"),
                new Task("Леонард", "моделирование эксперимента"),
                new Task("Говард", "разработка инструментов"),
                new Task("Раджеш", "анализ данных")
        );

        tasks.forEach(executorService::execute);
        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(10, TimeUnit.SECONDS)) {
                System.out.println("Не все задачи завершены вовремя. Принудительная остановка.");
                executorService.shutdownNow();
            } else {
                System.out.println("Все задания завершены.");
            }
        } catch (InterruptedException e) {
            System.out.println("Основной поток прерван.");
            executorService.shutdownNow();
        }
    }
}
