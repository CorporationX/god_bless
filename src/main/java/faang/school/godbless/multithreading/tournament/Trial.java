package faang.school.godbless.multithreading.tournament;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Trial implements Runnable {

    private String knightName;
    private String trialName;

    @Override
    public void run() {

        try {
            System.out.printf("> trial %s has started by %s%n", trialName, knightName);

            Thread.sleep(3000);

            System.out.printf("> trial %s was ended by %s%n", trialName, knightName);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
