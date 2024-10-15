package tasks.bjs2_35850;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;

@Getter
@AllArgsConstructor
public class PowerCalculator extends Thread {
    private Map<Character, Integer> charactersPower;
    private Character character;
    private final int THREAD_SLEEP_MILLISECOND = 5_000;

    @Override
    public void run() {
        try {
            System.out.println("Текущий поток : " + Thread.currentThread().getId());
            Thread.sleep(THREAD_SLEEP_MILLISECOND);
            charactersPower.put(character, character.getPower());
            System.out.println("Расчет для потока " + Thread.currentThread().getId() + " закончен");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
