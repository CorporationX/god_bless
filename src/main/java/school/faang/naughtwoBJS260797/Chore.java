package school.faang.naughtwoBJS260797;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Chore implements Runnable {
    private String title;

    @Override
    public void run() {
        try {
            System.out.printf("Thread %s is processing task '%s'%n", Thread.currentThread().getName(), title);
            Thread.sleep(1000);
            System.out.printf("Task '%s' is completed%n", title);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
