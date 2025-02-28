package school.faang.task_BJS2_60816;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Chore implements Runnable {
    private final String title;

    @Override
    public void run() {
        final int min_duration = 500; // Минимальное время выполнения (в миллисекундах)
        final int max_duration = 2000; // Максимальное время выполнения (в миллисекундах)
        final int task_duration_ms  = (int) (Math.random() * (max_duration - min_duration + 1)) + min_duration;

        System.out.println("\"" + Thread.currentThread().getName() + "\"" +
                " has just started the chore " + "\"" + title + "\"");
        try {
            Thread.sleep(task_duration_ms); //имитация выполнения задачи
        } catch (InterruptedException e) {
            System.out.println("The chore " + title + " is interrupted");
            Thread.currentThread().interrupt();
        }
        System.out.println("\"" + Thread.currentThread().getName() + "\"" +
                " has just performed " + "\"" + title + "\"");
    }
}