package school.faang.sprint_3.task_48855;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Chore implements Runnable {
    private static final int FIVE_SECONDS = 5000;
    private String chore;

    @Override
    public void run() {
        if (chore == null) {
            throw new IllegalStateException("Задание не может быть пустым (null)");
        }
        System.out.println(Thread.currentThread().getName() + " выполняется задачу " + chore);
        try {
            Thread.sleep(FIVE_SECONDS);
            System.out.println("Задача " + chore + " выполнена");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Задача " + chore + "была прервана: " + e.getMessage());
        }
    }
}
