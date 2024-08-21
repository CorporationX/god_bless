package faang.school.godbless.sprint.three.heroes;

import lombok.Getter;

@Getter
public class PowerThread extends Thread {
    private final Unit unit;
    private int power;

    public PowerThread(Unit unit) {
        this.unit = unit;
    }

    @Override
    public void run() {
        this.power = this.unit.getPower();
    }
}
