package faang.school.godbless.multithreading.weasley;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Chore implements Runnable {
    private String chore;
    @Override
    public void run() {
        System.out.printf("%s выполняет задачу %s\n", Thread.currentThread().getName(), chore);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println("Работа прервана");
        }

        System.out.printf("%s завершает задачу %s\n", Thread.currentThread().getName(), chore);
    }
}
