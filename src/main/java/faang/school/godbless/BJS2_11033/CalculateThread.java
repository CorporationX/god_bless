package faang.school.godbless.BJS2_11033;

import lombok.Getter;

@Getter
public class CalculateThread extends Thread {
    private final Warrior warrior;
    private int power;

    @Override
    public void run() {
        power = warrior.getPower();
    }

    public CalculateThread(Warrior warrior) {
        this.warrior = warrior;
    }
}
