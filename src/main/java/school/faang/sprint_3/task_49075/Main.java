package school.faang.sprint_3.task_49075;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    public static final int THREADS_SIZE = 4;
    public static final int TIMEOUT = 30;

    public static void main(String[] args) {
        List<Runnable> tasks = getRunnables();
        ExecutorService executor = Executors.newFixedThreadPool(THREADS_SIZE);

        for (Runnable task : tasks) {
            executor.submit(task);
        }

        executor.shutdown();

        try {
            executor.awaitTermination(TIMEOUT, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            log.error("Поток прерван при ожидании завершения задачи");
        }

        System.out.println("Все пользователи завершили задачи");
    }

    private static List<Runnable> getRunnables() {
        House house = new House(List.of("Маг", "Воин"));
        User alex = new User("Alex");
        User bob = new User("Bob");
        User tom = new User("Tom");
        User ron = new User("Ron");

        return List.of(
                () -> bob.joinHouse(house),
                () -> alex.joinHouse(house),
                () -> tom.joinHouse(house),
                () -> bob.leaveHouse(house),
                () -> alex.leaveHouse(house),
                () -> ron.joinHouse(house)
        );
    }
}
