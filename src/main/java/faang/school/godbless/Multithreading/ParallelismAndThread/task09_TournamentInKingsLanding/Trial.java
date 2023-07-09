package faang.school.godbless.Multithreading.ParallelismAndThread.task09_TournamentInKingsLanding;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Trial implements Runnable{
    private String knightName;
    private String trialName;

    @Override
    public void run() {
        System.out.println(knightName+": is completing "+trialName);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(knightName+": has completed "+trialName);
    }
}
