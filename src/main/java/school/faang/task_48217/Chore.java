package school.faang.task_48217;

import lombok.Getter;
import school.faang.exception.CheckException;

@Getter
public class Chore implements Runnable {
    private static final int SLEEP_DURATION = 9000;
    private final String chore;

    public Chore(String chore) {
        if (chore == null || chore.isEmpty()) {
            throw new CheckException("chore");
        }

        this.chore = chore;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " выполняет задачу: " + chore);
            Thread.sleep(SLEEP_DURATION);
            System.out.println("Задача: " + chore + " выполнена!");
        } catch (InterruptedException e) {
            System.out.println("Задача " + chore + " была прервана.");
        }
    }
}
