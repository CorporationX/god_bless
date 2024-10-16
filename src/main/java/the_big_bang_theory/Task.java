package the_big_bang_theory;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Random;

@Data
@AllArgsConstructor
public class Task implements Runnable {
    private String name;
    private String task;
    private final Random random = new Random();
    private static final int MIN_SECOND_ON_TASK = 5;
    private static final int MAX_SECOND_ON_TASK = 10;
    
    @Override
    public void run() {
        System.out.printf("%s начал работу над: %s%n", name, task);
        try {
            Thread.sleep(random.nextInt((MAX_SECOND_ON_TASK - MIN_SECOND_ON_TASK) + MIN_SECOND_ON_TASK) * 1000);
        } catch (InterruptedException e) {
            System.out.printf("%s оборвал задачу%n", name);
            Thread.currentThread().interrupt();
            return;
        }
        System.out.printf("%s завершил задачу: %s%n", name, task);
    }
}
