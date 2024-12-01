package school.faang.BJS235895;

import lombok.Getter;

public class MyThreads extends Thread {
    private final Warrior warrior;
    @Getter
    private int totalPower;

    public MyThreads(Warrior warrior) {
        this.warrior = warrior;
    }

    @Override
    public void run() {
        totalPower += (warrior.getPower());
    }
}
