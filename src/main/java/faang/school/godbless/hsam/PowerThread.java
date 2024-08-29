package faang.school.godbless.hsam;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;

public class PowerThread implements Callable<Integer> {

    private List<Unit> units;
    private int power;

    public PowerThread(List<Unit> units) {
        this.units = new ArrayList<>(units);
    }

    @Override
    public Integer call() {
        return power = units.stream()
                .mapToInt(Unit::getPower).sum();
    }
}
