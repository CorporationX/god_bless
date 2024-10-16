package school.BJS2_36668;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Task implements Runnable {

    private String name;
    private String task;

    @Override
    public void run() {
        try {
            System.out.println("Задача начата: " + task);
            Thread.sleep(3000);
            System.out.println("Задача завершена: " + task);
        } catch (InterruptedException e) {
            System.out.println("Задача была прервана");
        }
    }
}
