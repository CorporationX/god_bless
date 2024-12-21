package school.faang.sprint3.task3;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Chore implements Runnable {

    private String chore;

    public void run() {

        System.out.println(Thread.currentThread().getName() + " is doing " + chore);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
