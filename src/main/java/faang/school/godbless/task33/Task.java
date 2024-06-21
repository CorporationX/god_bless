package faang.school.godbless.task33;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Task implements Runnable{
    private String task;
    private String name;
    @Override
    public void run() {
        System.out.println(task);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("task "+task+" interrupted");
        }

    }

}
