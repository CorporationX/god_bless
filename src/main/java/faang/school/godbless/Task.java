package faang.school.godbless;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Task implements Runnable{
    String name;
    String task;
    @Override
    public void run() {
        System.out.println(getName() + " start " + getTask());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(getName() + " finished " + getTask());
    }
}
