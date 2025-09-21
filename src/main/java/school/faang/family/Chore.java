package school.faang.family;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Chore implements Runnable {

    private String task;
    private final int sleepingTime = 1000;

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " выполняет задачу: " + task);
        try {
            Thread.sleep(sleepingTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }
}
