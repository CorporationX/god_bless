package faang.school.godbless.bigBangTheory;

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
            if(executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                System.out.println("Все задачи выполнены.");
            } else {
                System.out.println("Не все задачи завершены за отведенное время.");
            }
        } catch (InterruptedException e) {
            System.err.println("Ожидание выполнения задач было прервано.");
        }
    }
}
