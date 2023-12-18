package faang.school.godbless.tournament;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

import java.util.Random;

@AllArgsConstructor
public class Trial implements Runnable {
    private String knightName;
    private String trialName;

    @SneakyThrows
    @Override
    public void run() {
        try {
            System.out.println(knightName + " приступает к испытанию");
            Thread.sleep(new Random().nextInt(30000));
            int random = new Random().nextInt(10);
            if (random % 2 == 0) {
                System.out.println(knightName + " прошел испытание:" + trialName);
            } else {
                System.out.println(knightName + " провалил испытание:" + trialName);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
