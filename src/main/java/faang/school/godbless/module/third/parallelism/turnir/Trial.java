package faang.school.godbless.module.third.parallelism.turnir;

import java.util.Random;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Trial implements Runnable {
    private String knightName;
    private String trialName;
    
    @Override
    public void run() {
        System.out.printf("Рыцарь %s выполняет испытание %s %n", knightName, trialName);
        try {
            Thread.sleep(new Random().nextInt(100, 1000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.printf("Рыцарь %s выполнил испытание %s %n", knightName, trialName);
    }
}
