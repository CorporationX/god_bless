package faang.school.godbless.module.third.parallelism.bang;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Task implements Runnable {
    private String name;
    private String task;
    
    @Override
    public void run() {
        System.out.printf("%s принялся за задачу %s %n", name, task);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.printf("%s закончил задачу %s %n", name, task);
    }
}
