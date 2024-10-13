package bjs2_35729;

import lombok.Getter;

import java.util.List;

public class PowerCalculator extends Thread {
    private List<Character> army;
    @Getter
    private int totalPower;

    public PowerCalculator(List<Character> army) {
        this.army = army;
    }

    @Override
    public void run() {
        for (Character character : army) {
            totalPower += character.getPower();
        }
    }
}
