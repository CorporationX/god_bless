package faang.school.godbless.module.third.parallelism.poor;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Chore implements Runnable {
    private String taskName;
    
    @Override
    public void run() {
        System.out.printf("%s выполняет задание %s %n", Thread.currentThread().getName(), taskName);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
