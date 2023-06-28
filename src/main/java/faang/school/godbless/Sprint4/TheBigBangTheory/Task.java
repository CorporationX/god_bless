package faang.school.godbless.Sprint4.TheBigBangTheory;

import lombok.AllArgsConstructor;

import java.util.Date;

@AllArgsConstructor
public class Task implements Runnable{
    private String name;
    private Runnable task;
    @Override
    public void run() {
        System.out.printf("Task - %s, начало - %s\n",name,new Date());
        task.run();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException("Program is stopped");
        }
    }
}
