package faang.school.godbless.bigBangTheory;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter

public class Task implements  Runnable{
    private String name;
    private String task;
    @Override
    public void run() {
        try {
            System.out.println(name + " started the task: " + task);
            Thread.sleep(6000);
            System.out.println(name + " completed the task: " + task);
        } catch (InterruptedException e) {
            System.out.println(name + " was interrupted in the middle of a task: " + task);
        }
    }

}
