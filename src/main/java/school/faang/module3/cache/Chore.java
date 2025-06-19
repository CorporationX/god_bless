package school.faang.module3.cache;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.concurrent.TimeUnit;

@Getter
@AllArgsConstructor
public class Chore implements Runnable {
    private String chore;


    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        String name = thread.getName();
        System.out.printf("\tThread \"%s\" started to work: \"%s\"\n", name, chore);
        try {
            TimeUnit.SECONDS.sleep(1);
            System.out.printf("\tThread \"%s\" has finished its work: \"%s\"\n", thread.getName(), chore);
        } catch (InterruptedException e) {
            thread.interrupt();
            System.out.printf("error on thread \"%s\" while working \"%s\": \"%s\"\n",
                    thread.getName(), chore, e.getMessage());
        }
    }
}
