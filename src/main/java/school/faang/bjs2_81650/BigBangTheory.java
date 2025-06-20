package school.faang.bjs2_81650;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class BigBangTheory {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(4);

        log.info("Распределяем задачи");

        Task[] tasks = new Task[]{new Task("Шелдон", "подготовку теории"),
                new Task("Леонард", "моделирование эксперимента"),
                new Task("Говард", "разработку инструментов"),
                new Task("Раджеш", "анализ данных")};

        for (Task task : tasks) {
            executorService.execute(task);
        }

        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(1, TimeUnit.MINUTES)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            System.out.println("Метод прерван");
            executorService.shutdownNow();
            throw new RuntimeException(e);
        }
        log.info("Все задачи выполнены");
    }
}
