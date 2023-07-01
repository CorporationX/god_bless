package faang.school.godbless.thread.tournament;

import lombok.Data;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@Data
public class Trial implements Runnable {
    private String knightName;
    private String trialName;
    private String result;

    public Trial(String knightName, String trialName) {
        this.knightName = knightName;
        this.trialName = trialName;
        this.result = Result.values()[(new Random().nextInt(0, Result.values().length))].name;
    }

    @Override
    public void run() {
        try {
            System.out.println(trialName + " начал рыцарь " + knightName);
            TimeUnit.SECONDS.sleep(new Random().nextInt(1, 10));
            System.out.println(knightName + " завершил испытание " + trialName + " с результатом " + result);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
