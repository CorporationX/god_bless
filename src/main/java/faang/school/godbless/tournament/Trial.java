package faang.school.godbless.tournament;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Trial implements Runnable {

    private String knightName;
    private String trialName;

    @Override
    public void run() {
        System.out.println(String.format("Knight %s starts trial %s", knightName, trialName));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
