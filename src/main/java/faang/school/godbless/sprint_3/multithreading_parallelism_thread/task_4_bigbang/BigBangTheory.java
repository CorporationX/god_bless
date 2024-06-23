package faang.school.godbless.sprint_3.multithreading_parallelism_thread.task_4_bigbang;

import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BigBangTheory {
    private static final String END_WORK = "Well done";

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

        while (!executorService.isTerminated()){

        }

        System.out.println(END_WORK);

    }
}
