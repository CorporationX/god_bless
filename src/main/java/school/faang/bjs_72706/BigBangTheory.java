package school.faang.bjs_72706;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(4);

        Task sheldon = new Task("Шелдон", "подготовка теории");
        Task leonard = new Task("Леонард", "моделирование эксперимента");
        Task howard = new Task("Говард", "разработка инструментов");
        Task rajesh = new Task("Раджеш", "анализ данных");

        executor.execute(sheldon);
        executor.execute(leonard);
        executor.execute(howard);
        executor.execute(rajesh);

        executor.shutdown();

        try {
            if (!executor.awaitTermination(3, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }

        System.out.println("Все задачи завершены.");
    }

}
