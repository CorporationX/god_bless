package the.big.bang.theory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    private static final int THREAD_POOL_SIZE = 4;
    private final static int MAX_DURATION_MINUTES = 5;


    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        Task task1 = new Task("Шелдон", "подготовка теории");
        Task task2 = new Task("Леонард", "моделирование эксперимента");
        Task task3 = new Task("Говард", "разработка инструментов");
        Task task4 = new Task("Раджеш", "анализ данных");

        service.execute(task1);
        service.execute(task2);
        service.execute(task3);
        service.execute(task4);
        service.shutdown();

        try {
            if (service.awaitTermination(MAX_DURATION_MINUTES, TimeUnit.MINUTES)) {
                System.out.println("Все задачи были выполнены!");
            } else {
                service.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
