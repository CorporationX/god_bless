package school.faang.bjs2_89555;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class BigBangTheory {
    private static final int THREAD = 4;
    private static final int AWAIT_TIME = 1;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(THREAD);
        Task taskOne = new Task("Sheldon", "theory preparation");
        Task taskTwo = new Task("Leonard", "simulation of experiment");
        Task taskThree = new Task("Howard", "tool development");
        Task taskFour = new Task("Rajesh", "data analysis");
        List<Task> tasks = List.of(taskOne, taskTwo, taskThree, taskFour);

        for (int i = 0; i < 4; i++) {
            executor.submit(tasks.get(i));
        }
        executor.shutdown();
        try {
            if (!executor.awaitTermination(AWAIT_TIME, TimeUnit.MINUTES)) {
                log.warn("не все задачи завершились вовремя, закрываем пул потоков.");
                executor.shutdownNow();
            } else {
                log.info("все доставки выполнены успешно.");
            }
        } catch (InterruptedException e) {
            log.error("главный поток прерван");
            executor.shutdownNow();
        }
    }
}
