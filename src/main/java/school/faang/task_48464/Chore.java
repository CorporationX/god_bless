package school.faang.task_48464;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Chore implements Runnable {
    private static final long MILLIS = 5000;

    private String chore;

    @Override
    public void run() {
        try {
            System.out.println(String.format("Name of the thread: %s. Name of the work: %s",
                    Thread.currentThread().getName(), chore));
            Thread.sleep(MILLIS);
            System.out.println(String.format("%s is done", chore));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
