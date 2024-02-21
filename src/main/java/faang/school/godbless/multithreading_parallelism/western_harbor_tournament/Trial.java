package faang.school.godbless.multithreading_parallelism.western_harbor_tournament;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Trial implements Runnable {
    private String knightName;
    private String trialName;

    @Override
    public void run() {
        System.out.println(String.format("%s начал испытание %s", knightName, trialName));
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(String.format("%s прошел испытание", knightName));
    }
}
