package faang.school.godbless.multithreading.task_4;

import faang.school.godbless.multithreading.task_4.model.Task;
import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class BigBangTheory {
    private static final int NUMBER_OF_THREADS = 4;
    private static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static void main(String[] args) throws InterruptedException {
        Task sheldonTask = new Task("Шелдон", "подготовка теории");
        Task leonardTask = new Task("Леонард", "моделирование эксперимента");
        Task howardTask = new Task("Говард", "разработка инструментов");
        Task rajeshTask = new Task("Раджеш", "анализ данных");
        List<Task> tasks = Arrays.asList(sheldonTask, leonardTask, howardTask, rajeshTask);
        tasks.forEach(EXECUTOR::execute);
        try {
            EXECUTOR.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }
        EXECUTOR.shutdown();
        System.out.println("Все задачи выполнены? - " + EXECUTOR.isTerminated());
    }
}