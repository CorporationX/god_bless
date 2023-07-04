package faang.school.godbless.sprint_3.multithreading.tournament;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.concurrent.ThreadLocalRandom;

@AllArgsConstructor
@Getter
public class Trial implements Runnable {
    private String knightName;
    private String trialName;

    @Override
    public void run() {
        System.out.printf("%s начинает свое испытание %s%n", knightName, trialName);
        try {
            int time = ThreadLocalRandom.current().nextInt((4) + 1) * 1000;
            Thread.sleep(time);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        System.out.printf("Trial: %s is completed!%n", trialName);
    }
}
