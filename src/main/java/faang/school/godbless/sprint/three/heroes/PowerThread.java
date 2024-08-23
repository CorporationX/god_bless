package faang.school.godbless.sprint.three.heroes;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class PowerThread extends Thread {
    private final List<Unit> units = new ArrayList<>();
    private int power;

    public void addUnit(Unit unit) {
        this.units.add(unit);
    }

    @Override
    public void run() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        this.power = this.units.stream()
                .mapToInt(Unit::getPower).sum();
    }
}
