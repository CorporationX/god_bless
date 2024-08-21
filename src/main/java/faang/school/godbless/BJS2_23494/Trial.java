package faang.school.godbless.BJS2_23494;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class Trial implements Runnable{
    private String knightName;
    private String trialName;

    @Override
    public void run() {
        System.out.println(knightName + " выполняет испытание " + trialName);

        try {
            Thread.sleep(new Random().nextInt(1000, 5000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        String result = new Random().nextBoolean() ? "прошел" : "не прошел";
        System.out.printf("%s %s испытание: %s%n", knightName, result, trialName);
    }



}
