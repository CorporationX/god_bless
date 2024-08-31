package faang.school.godbless.BJS2_23477;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Army {

    private List<Unit> army = new ArrayList<>();

    public void addUnit(Unit unit) {
        army.add(unit);
    }

    public int calculateTotalPower() {
        int totalPower = 0;
        List<UnitPowerThread> threads = new ArrayList<>();
        for (Unit unit : army) {
            UnitPowerThread thread = new UnitPowerThread(unit, totalPower);
            threads.add(thread);
            thread.start();
        }
        for (UnitPowerThread thread : threads) {
            try {
                thread.join();
                totalPower += thread.getResult();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return totalPower;
    }
}
