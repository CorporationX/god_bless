package school.faang.task_48810;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Chore implements Runnable {

    private String chore;

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + ": " + chore);
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
