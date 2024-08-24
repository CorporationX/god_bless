package faang.school.godbless.BJS2_24029;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class Task implements Runnable {
    private String name;
    private String task;

    @Override
    public void run() {
        System.out.println(name + " begin working on " + task);
        try {
            Thread.sleep(new Random().nextInt(1000, 5000));
        } catch (InterruptedException e) {
            throw new RuntimeException("Interrupt task");
        }
    }
}
