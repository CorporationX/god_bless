package faang.school.godbless.Sprint_4.Multithreading_Parallelism.Tournament;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Trial implements Runnable{
    private String knightName;
    private String trialName;

    @Override
    public void run() {
        System.out.printf("Knight: %s is doing: %s\n",  knightName, trialName);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.printf("Trial: %s Has been completed by %s\n", trialName, knightName);
    }
}
