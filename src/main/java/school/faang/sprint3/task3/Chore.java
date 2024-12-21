package school.faang.sprint3.task3;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Chore implements Runnable {

    private String chore;

    private static final int THREAD_TIME = 100;

    public void run() {

        System.out.println(Thread.currentThread().getName() + " is doing " + chore);
        try {
            Thread.sleep(THREAD_TIME);
        } catch (InterruptedException e) {
            e.fillInStackTrace();
        }

    }
}
