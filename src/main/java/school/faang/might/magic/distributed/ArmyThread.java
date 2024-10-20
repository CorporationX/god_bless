package school.faang.might.magic.distributed;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
class ArmyThread extends Thread {
    private List<Integer> powerOfUnits = new ArrayList<>();
    private int result;

    public ArmyThread(List<Unit> units) {
        for (Unit unit : units) {
            powerOfUnits.add(unit.getPower());
        }
    }

    @Override
    public void run() {
        result = powerOfUnits.stream().mapToInt(Integer::intValue).sum();
    }
}
