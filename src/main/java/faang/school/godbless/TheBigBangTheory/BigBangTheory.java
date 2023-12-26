package faang.school.godbless.TheBigBangTheory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        Task sheldon = new Task("Шелдон", "подготовка теории");
        Task leonard = new Task("Леонард", "моделирование эксперимента");
        Task howard = new Task("Говард", "разработка инструментов");
        Task raj = new Task("Раджеш", "анализ данных");

        executorService.execute(sheldon);
        executorService.execute(leonard);
        executorService.execute(howard);
        executorService.execute(raj);

        executorService.shutdown();
       // executorService.shutdownNow();
        try {
            // Ждем завершения всех потоков
            executorService.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Работа окончена");
    }
}
