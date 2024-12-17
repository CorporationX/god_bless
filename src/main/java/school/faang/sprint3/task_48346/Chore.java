package school.faang.sprint3.task_48346;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Chore implements Runnable {

    private final String chore;

    @Override
    public void run() {
        System.out.printf("\nHello, I am thread %s and I am doing %s", Thread.currentThread().getName(), chore);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.printf("\nI am thread %s and I've completed my task successfully", Thread.currentThread().getName());
    }
}
