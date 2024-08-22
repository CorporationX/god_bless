package theory;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
public class Task implements Runnable {
    private String name;
    private String task;

    @Override
    public void run() {
        try {
            Thread.sleep(300);
            System.out.println(name + " - " + task + ".");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
