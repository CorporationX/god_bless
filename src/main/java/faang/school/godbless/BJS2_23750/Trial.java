package faang.school.godbless.BJS2_23750;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class Trial implements Runnable {

    private static Random random = new Random();
    private String knightName;
    private String trialName;

    @Override
    public void run() {
        System.out.printf("%s пытается выполнить испытание: %s%n", knightName, trialName);

        try {
            Thread.sleep(random.nextLong(1_000, 10_000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        String result = random.nextBoolean() ? "прошел" : "не прошел";
        System.out.printf("%s %s испытание по именем: %s%n", knightName, result, trialName);
    }
}
