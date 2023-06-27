package faang.school.godbless.weasley_family;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Chore implements Runnable{

    private String task;

    @Override
    public void run() {
       String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " has started to " + task);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(threadName + " has finished to " + task);
    }
}
