package school.faang.module3.cache;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.concurrent.TimeUnit;

@Getter
@AllArgsConstructor
public class Chore implements Runnable {
    private String chore;
    private static final int SLEEP_TIME = 1;

    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        String name = thread.getName();
        System.out.printf("\tThread \"%s\" started to work: \"%s\"\n", name, chore);
        try {
            TimeUnit.SECONDS.sleep(SLEEP_TIME);
            System.out.printf("\tThread \"%s\" has finished its work: \"%s\"\n", thread.getName(), chore);
        } catch (InterruptedException e) {
            thread.interrupt();
            System.out.printf("error on thread \"%s\" while working \"%s\": \"%s\"\n",
                    thread.getName(), chore, e.getMessage());
        }
    }
}
