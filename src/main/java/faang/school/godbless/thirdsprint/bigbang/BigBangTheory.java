package faang.school.godbless.thirdsprint.bigbang;

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
