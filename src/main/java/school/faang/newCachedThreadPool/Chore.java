package school.faang.newCachedThreadPool;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Chore implements Runnable {
    private static final long SLEEP_TIME_MILLIS = 2000;
    private String chore;

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " поток выполняет задачу: " + chore);
            Thread.sleep(SLEEP_TIME_MILLIS);
            System.out.println(chore + " выполнена ");
        } catch (InterruptedException e) {
            System.out.println("задача: " + chore + " была прервана");
            Thread.currentThread().interrupt();
        }
    }
}