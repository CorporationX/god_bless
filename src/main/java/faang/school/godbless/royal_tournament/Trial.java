package faang.school.godbless.royal_tournament;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class Trial extends Thread {
    private String knightName;
    private String trialName;

    @Override
    public void run() {
        int random = new Random().nextInt(3);
        System.out.println(knightName + " выполняет испытание " + trialName);
        try {
            Thread.sleep(random * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException("Ошибка прерывания потока!");
        }
        System.out.println(knightName + " выполнил испытание " + trialName);
    }
}
