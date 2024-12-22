package school.faang.sprint3.task_bjs247986;

import lombok.Getter;

public class PowerThread extends Thread {
    private final Warrior warrior;
    @Getter
    private int power;

    public PowerThread(Warrior warrior) {
        this.warrior = warrior;
    }

    public void run() {
        power = warrior.getPower();
    }

}
