package faang.school.godbless.tournament;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Trial implements Runnable {

    private String knightName;
    private String trialName;

    @Override
    public void run() {
        System.out.println(knightName + " начал выполнять испытание - " + trialName);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(knightName + " закончил выполнять испытание - " + trialName);
    }
}
