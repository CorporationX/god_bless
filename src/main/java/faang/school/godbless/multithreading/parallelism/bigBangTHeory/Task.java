package faang.school.godbless.multithreading.parallelism.bigBangTHeory;

import lombok.AllArgsConstructor;

import java.util.random.RandomGenerator;

@AllArgsConstructor
public class Task implements Runnable {
    private String name;
    private String task;

    @Override
    public void run() {
        System.out.println(name + " began task - " + task);
        try {
            Thread.sleep(RandomGenerator.getDefault().nextInt(10000));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
        System.out.println(name + " finished task - " + task);
    }
}
