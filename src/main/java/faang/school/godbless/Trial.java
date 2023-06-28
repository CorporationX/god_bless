package faang.school.godbless;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.SneakyThrows;

import java.util.Random;

@Data
@AllArgsConstructor
public class Trial implements Runnable {
    private String knightName;
    private String trialName;

    @SneakyThrows
    @Override
    public void run() {
        System.out.printf("%s %s %s \n", knightName, trialName, Thread.currentThread().getName());
        Thread.sleep(new Random().nextInt(1000, 5000));
        System.out.println(knightName + "has done");
    }
}
