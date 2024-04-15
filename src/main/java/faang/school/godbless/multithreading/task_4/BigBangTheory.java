package faang.school.godbless.multithreading.task_4;

import faang.school.godbless.multithreading.task_4.model.Task;

import javax.sound.midi.Soundbank;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
        EXECUTOR.shutdown();
        if (EXECUTOR.isShutdown()) {
            System.out.println("Все задачи выполнены");
        }


    }
}