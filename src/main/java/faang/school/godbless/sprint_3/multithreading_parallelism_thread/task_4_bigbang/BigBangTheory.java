package faang.school.godbless.sprint_3.multithreading_parallelism_thread.task_4_bigbang;

import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    private static final String MSG_FINISH = "Well done";
    private static final String MSG_ERROR = "Work interrupted";
    public static final int TIME_OUT = 10;

    public static void main(String[] args) {
        Map<String, String> nameTaskMap = Map.of(
                "Sheldon", "подготовка теории.",
                "Leonard", "моделирование эксперимента.",
                "Govard", "разработка инструментов.",
                "Radjesh", "анализ данных.");

        ExecutorService executorService = Executors.newFixedThreadPool(nameTaskMap.size());

        for (String name : nameTaskMap.keySet()) {
            Task task = new Task(name, nameTaskMap.get(name));
            executorService.submit(task);
        }

        executorService.shutdown();

        try {
            executorService.awaitTermination(TIME_OUT, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(MSG_ERROR);
        }

        System.out.println(MSG_FINISH);

    }
}
