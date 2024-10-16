package theBigBangTheory_36686;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    private final static int THREAD_POOL_SIZE=4;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        List<Task> tasks = List.of(
                new Task("Шелдон", "подготовка теории"),
                new Task("Леонардо", "моделирование эксперимента"),
                new Task("Говард", "разработка инструментов"),
                new Task("Раджеш", "анализ данных")
        );

        for (Task task : tasks) {
            executor.execute(task);
        }
        executor.shutdown();
        try {
            if(!executor.awaitTermination(2, TimeUnit.SECONDS)){
                System.out.println("Кто не успел тот Киркоров!");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}
