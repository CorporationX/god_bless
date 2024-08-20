package faang.school.godbless.javamultithreading.task5;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Chore implements Runnable {
    private String chore;

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " выполнение " + chore);
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            System.out.println("Выполнение прервалось");
        }
        System.out.println(chore + " завершено");
    }
}
