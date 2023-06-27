package sprint4.homm;

import lombok.EqualsAndHashCode;
import lombok.Value;
import sprint4.homm.unit.Unit;

@Value
@EqualsAndHashCode(callSuper = true)
public class PowerCounterThread extends Thread {
    private volatile static int totalPower = 0;
    Unit unit;

    @Override
    public void run() {
        incrementTotalPower(unit.getPower());
    }

    private synchronized static void incrementTotalPower(int power) {
        totalPower += power;
    }

    public static void dropTotalPower() {
        totalPower = 0;
    }

    public static int getTotalPower() {
        return totalPower;
    }
}
