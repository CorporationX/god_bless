package faang.school.godbless.the.big.bang.theory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.util.concurrent.TimeUnit.SECONDS;

public class BigBangTheory {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(4);
        Task task1 = new Task("Шелдон", "подготовка теории");
        Task task2 = new Task("Леонард", "моделирование эксперимента");
        Task task3 = new Task("Говард", "разработка инструментов");
        Task task4 = new Task("Раджеш", "анализ данных");

        executor.submit(task1);
        executor.submit(task2);
        executor.submit(task3);
        executor.submit(task4);
        executor.shutdown();


        boolean isDone = executor.awaitTermination(6, SECONDS);
        if(isDone == true) {
            System.out.println("Задачи сделаны");
        }
    }
}
