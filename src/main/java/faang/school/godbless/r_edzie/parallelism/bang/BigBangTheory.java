package faang.school.godbless.r_edzie.parallelism.bang;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    private static final int THREAD_AMOUNT = 4;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_AMOUNT);

        Task sheldon = new Task("Шелдон", "подготовка теории");
        Task leonard = new Task("Леонард", "моделирование эксперимента");
        Task govard = new Task("Говард", "разработка инструментов");
        Task radzhesh = new Task("Раджеш", "анализ данных");

        List<Task> tasks = List.of(sheldon, leonard, govard, radzhesh);
        tasks.forEach(executorService::submit);

        executorService.shutdown();
        executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);

        System.out.println("Done");
    }
}
