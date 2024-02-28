package faang.school.godbless.BJS2_3187;

import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    public static void main(String[] args) throws InterruptedException {
        var executorService = Executors.newFixedThreadPool(4);
        var tasks = new ArrayList<Task>();
        tasks.add(new Task("Шелдон", "подготовка теории"));
        tasks.add( new Task("Леонард", "моделирование эксперимента"));
        tasks.add( new Task("Говард", "разработка инструментов"));
        tasks.add( new Task("Раджеш", "анализ данных"));
        tasks.forEach(executorService::execute);

        executorService.shutdown();
        boolean terminationResult = executorService.awaitTermination(60, TimeUnit.SECONDS);
        executorService.shutdownNow();
        if (terminationResult) {
            System.out.println("All tasks done!");
        } else {
            System.out.println("Not all tasks have been completed!");
        }


    }
}
