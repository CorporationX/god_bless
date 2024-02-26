package faang.school.godbless.cleaningtheweasleyfamily;

import lombok.AllArgsConstructor;
import java.util.Random;

@AllArgsConstructor
public class Chore implements Runnable {
    private String chore;

    @Override
    public void run() {
        Random random = new Random();
        System.out.println("Задача " + chore + " Обрабатывается в " + Thread.currentThread().getName());
        try {
            Thread.sleep(random.nextInt(1_0000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Задача " + chore + " выполнена.");
    }
}
