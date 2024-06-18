package faang.school.godbless.module1.sprint3.task6;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public class Task implements Runnable {
    private String name;
    private String task;


    @Override
    public void run() {
        System.out.println(task + " start execute");
        try {
            System.out.println("Task " + name + " execute done");
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e + "Task interrupted");
        }
    }
}
