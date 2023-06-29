package faang.school.godbless.multithreading.weasley;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Chore implements Runnable {
    private String chore;
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " выполняет задачу " + chore);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println("Работа прервана");
        }

        System.out.println(Thread.currentThread().getName() + " завершает задачу " + chore);
    }
}
