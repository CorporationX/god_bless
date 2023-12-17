package faang.school.godbless.multi_paral.task4big_bang;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        Task taskSheldon = new Task("Шелдон", "подготовка теории");
        Task taskLeonard = new Task("Леонард", "моделирование эксперимента");
        Task taskHoward = new Task("Говард", "разработка инструментов");
        Task taskRajesh = new Task("Раджеш", "анализ данных");


        executorService.submit(taskSheldon);
        executorService.submit(taskLeonard);
        executorService.submit(taskHoward);
        executorService.submit(taskRajesh);

        executorService.shutdown();
        executorService.awaitTermination(5, TimeUnit.MINUTES);

        System.out.println("------------------------------------------------------");
        System.out.println("Задачи выполнены");
    }
}
