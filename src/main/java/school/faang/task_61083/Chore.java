package school.faang.task_61083;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Random;

@AllArgsConstructor
@Getter
@ToString
public class Chore implements Runnable {
    private final String title;

    @Override
    public void run() {
        Random random = new Random();
        try {
            System.out.printf("Сейчас выполняется задача '%s' в потоке %s%n",
                    title, Thread.currentThread().getName());
            Thread.sleep(random.nextInt(1500, 5000));
            System.out.printf("Задача '%s' выполнена!%n", title);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Поток прерван! " + e);
        }
    }
}
