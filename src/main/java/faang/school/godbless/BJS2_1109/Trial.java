package faang.school.godbless.BJS2_1109;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class Trial implements Runnable{
    private String knightName;
    private String trialName;

    @Override
    public void run() {
        try {
            System.out.println(trialName+" is for "+knightName);
            Thread.sleep(5000);
            int random = new Random().nextInt(10);
            if (random % 2 == 0) {
                System.out.println(knightName+ " is completed "+trialName);
            } else {
                System.out.println(knightName+ " is failed "+trialName);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException("Thread.sleep in override method run");
        }
    }
}
