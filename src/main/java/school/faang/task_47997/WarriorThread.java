package school.faang.task_47997;

import lombok.Getter;

public class WarriorThread extends Thread {
    private final Unit unit;
    @Getter
    private int power;

    public WarriorThread(Unit warrior) {
        this.unit = warrior;
    }

    @Override
    public void run() {
        this.power = unit.getPower();
    }
}
