package school.faang.task_BJS2_60816;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Chore implements Runnable {
    private final String title;

    @Override
    public void run() {
        final int MIN_DURATION = 500; // Минимальное время выполнения (в миллисекундах)
        int MAX_DURATION = 2000; // Максимальное время выполнения (в миллисекундах)
        final int TASK_DURATION_MS  = (int) (Math.random() * (MAX_DURATION - MIN_DURATION + 1)) + MIN_DURATION;

        System.out.println("\"" + Thread.currentThread().getName() + "\"" +
                " has just started the chore " + "\"" + title + "\"");
        try {
            Thread.sleep(TASK_DURATION_MS); //имитация выполнения задачи
        } catch (InterruptedException e) {
            System.out.println("The chore " + title + " is interrupted");
            Thread.currentThread().interrupt();
        }
        System.out.println("\"" + Thread.currentThread().getName() + "\"" +
                " has just performed " + "\"" + title + "\"");
    }
}