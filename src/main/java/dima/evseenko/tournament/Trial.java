package dima.evseenko.tournament;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Random;

@Data
@AllArgsConstructor
public class Trial implements Runnable {
    private String knightName;
    private String trialName;

    @Override
    public void run() {
        System.out.printf("%s начал испытание %s%n", knightName, trialName);
        try {
            Thread.sleep(new Random().nextInt(4000 - 1000) + 1000);
            System.out.printf("%s успешно выполнил испытание %s%n", knightName, trialName);
        } catch (InterruptedException e) {
            throw new IllegalStateException("Ошибка выполнения испытания %s - %s".formatted(knightName, trialName));
        }
    }
}
