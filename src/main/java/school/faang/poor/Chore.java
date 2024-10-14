package school.faang.poor;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Chore implements Runnable{
    private final String choreName;

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        try {
            System.out.println("The thread is running: " + threadName + " for chore: " + choreName);
            Thread.sleep(100);
            System.out.println("The thread is done: " + threadName);
        } catch (InterruptedException e) {
            System.out.println("Something bad happened with thread: " + threadName);
        }
    }
}
