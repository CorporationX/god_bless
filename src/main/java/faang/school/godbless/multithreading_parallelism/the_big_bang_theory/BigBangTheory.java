package faang.school.godbless.multithreading_parallelism.the_big_bang_theory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    private static final int COUNT_THREAD = 4;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(COUNT_THREAD);
        Task firstTask = new Task("Шелдон", "Подготовка теории");
        Task secondTask = new Task("Леонард", "Моделирование эксперимента");
        Task thirdTask = new Task("Говард", "Разработка инструментов");
        Task fourthTask = new Task("Раджеш", "Анализ данных");
        List<Task> taskList = new ArrayList<>(Arrays.asList(firstTask, secondTask, thirdTask, fourthTask));
        for (int i = 0; i < taskList.size(); i++) {
            executorService.execute(taskList.get(i));
        }
        executorService.shutdown();
        executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);

        System.out.println("Все задачи решили");
    }
}
