package BJS2_11063;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class Army implements Runnable {
    private final List<? extends Object> units;
    private int totalPower = 0;

    public synchronized void calculateTotalPower(int power) {
        totalPower += power;
    }

    @Override
    public void run() {
        int power = 0;
        for (Object unit : units) {
            if (unit instanceof Archer) power += ((Archer) unit).power();
            else if (unit instanceof Swordsman) power += ((Swordsman) unit).power();
            else if (unit instanceof Mage) power += ((Mage) unit).power();
        }
        calculateTotalPower(power);
    }
}