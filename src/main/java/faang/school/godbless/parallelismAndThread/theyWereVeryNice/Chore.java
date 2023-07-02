package faang.school.godbless.parallelismAndThread.theyWereVeryNice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Chore implements Runnable {
    private String chore;

    @Override
    public void run() {
        System.out.println("Поток: " + Thread.currentThread().getName() + ". Начало выполнения задачи: " + chore);
        try {
            Thread.sleep((long) (Math.random() * 4000) + 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Поток: " + Thread.currentThread().getName() + ". Конец выполнения задачи: " + chore);
    }
}
