package faang.school.godbless.sprint_3.multithreading.bing_bang_theory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BigBangTheory {
    public static void main(String[] args) {
        Task first = new Task("Шелдон", "подготовке теории");
        Task second = new Task("Леонард ", "моделированию эксперимента");
        Task third = new Task("Говард ", "разработке инструментов");
        Task fourth = new Task("Раджеш ", "анализу данных");
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        executorService.submit(first);
        executorService.submit(second);
        executorService.submit(third);
        executorService.submit(fourth);
        executorService.shutdown();
        System.out.println("Task is over!");
    }
}
