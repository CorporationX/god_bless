package faang.school.godbless.kxnvg.heroesofmagic;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;

public class Army {

    private List<Unit> divisions = new ArrayList<>();

    public void addUnit(Unit unit) {
        divisions.add(unit);
    }

    public boolean deleteUnit(Unit unit) {
        if (divisions.contains(unit)) {
            divisions.remove(unit);
            return true;
        } else {
            return false;
        }
    }

    public int totalQuantityUnits() {
        return divisions.size();
    }

    @SneakyThrows
    public int calculateTotalPower() {
        List<PowerThread> threads = new ArrayList<>();
        int result = 0;

        for (Unit unit : divisions) {
            PowerThread powerThread = new PowerThread(unit);

            threads.add(powerThread);
            powerThread.start();
            powerThread.join();
        }
        for (PowerThread thread : threads) {
            result += thread.getUnitPower();
        }
        return result;
    }
}
