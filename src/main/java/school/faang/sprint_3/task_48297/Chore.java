package school.faang.sprint_3.task_48297;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

import java.util.Random;

@AllArgsConstructor
public class Chore implements Runnable {
    private String chore;

    @SneakyThrows
    @Override
    public void run() {
        Random random = new Random();
        int seconds = random.nextInt(1, 10) * 1000;
        Thread.sleep(seconds);
        System.out.printf(
                "Работа \"%s\" сделана потоком %s за %d секунд\n",
                chore,
                Thread.currentThread().getName(),
                seconds / 1000
        );

    }
}
