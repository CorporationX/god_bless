package faang.school.godbless.big_bang_theory;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {

    public static final int THREAD_COUNT = 4;

    public static void main(String[] args) throws InterruptedException {
        List<Task> taskList = Arrays.asList(
                new Task("Шелдон", "подготовка теории"),
                new Task("Леонард", "моделирование эксперимента"),
                new Task("Говард", "разработка инструментов"),
                new Task("Раджеш", "анализ данных")
        );

        ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);
        taskList.forEach(executor::execute);

        executor.shutdown();

        if (executor.awaitTermination(1, TimeUnit.MINUTES)) {
            System.out.println("Все задачи выполнены!");
        }
    }
}
