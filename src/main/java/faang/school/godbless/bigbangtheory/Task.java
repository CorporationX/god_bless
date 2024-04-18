package faang.school.godbless.bigbangtheory;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Slf4j
public class Task implements Runnable {

    private String name;
    private String task;

    @Override
    public void run() {
        System.out.println("Задача: " + task + " начата, исполнитель: " + name);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println("Задача прервана, описание: " + e.getMessage());
        }
    }
}
