package school.faang.sprint_3.task_49725;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss(3);
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        IntStream.range(1, 11)
                .mapToObj(i -> new Player(i, boss))
                .forEach(executorService::execute);

        executorService.shutdown();
    }
}
