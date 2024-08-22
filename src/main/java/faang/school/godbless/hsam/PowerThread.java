package faang.school.godbless.hsam;

import java.util.ArrayList;
import java.util.List;

public class PowerThread extends Thread {

    private List<Unit> units;
    private int power;

    public PowerThread(List<Unit> units) {
        this.units = new ArrayList<>(units);
    }

    @Override
    public void run() {
        power = units.stream()
                .mapToInt(Unit::getPower).sum();
    }

    public int getPower() {
        return power;
    }
}
