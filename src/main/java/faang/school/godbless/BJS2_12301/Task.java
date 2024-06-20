package faang.school.godbless.BJS2_12301;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class Task implements Runnable {
    private String name;
    private String task;

    @Override
    public void run() {
        System.out.println("Началось выполнение: " + task + ". Исполнитель: " + name);
        try {
            Thread.sleep(new Random().nextInt(1000, 5000));
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
