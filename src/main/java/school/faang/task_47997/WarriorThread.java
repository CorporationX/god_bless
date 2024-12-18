package school.faang.task_47997;

import lombok.Getter;

public class WarriorThread extends Thread {
    private final Warrior warrior;
    @Getter
    private int power;

    public WarriorThread(Warrior warrior) {
        this.warrior = warrior;
    }

    @Override
    public void run() {
        this.power = warrior.getPower();
    }
}
