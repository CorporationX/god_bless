package faang.school.godbless.BJS2_3189;

import lombok.Data;
import lombok.NonNull;
import lombok.SneakyThrows;

import java.util.Random;

@Data
public class Trial implements Runnable {
    private String knightName;
    @NonNull
    private String trialName;

    @SneakyThrows
    @Override
    public void run() {
        System.out.println(knightName + " starts " + trialName);
        Thread.sleep((new Random().nextInt(4) + 3) * 1000);
        System.out.println(knightName + " finished " + trialName);

    }
}
