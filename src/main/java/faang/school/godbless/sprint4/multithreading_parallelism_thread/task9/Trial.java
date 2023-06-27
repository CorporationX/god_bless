package faang.school.godbless.sprint4.multithreading_parallelism_thread.task9;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Trial implements Runnable {

    private String knightName;

    private String trialName;


    @Override
    public void run() {
        System.out.println(knightName + " выполняет " + trialName);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
