package faang.school.godbless.army_of_heroes;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<Unit> units = Arrays.asList(new Archer(25), new Swordsman(40), new Mage(50), new Mage(20), new Archer(25),
                new Swordsman(40), new Mage(50), new Mage(20), new Archer(25), new Swordsman(40), new Mage(50),
                new Mage(20), new Archer(25), new Swordsman(40), new Mage(50), new Mage(20));

        Army army = new Army(units);

        int totalPower = army.calculateTotalPower();
        System.out.println("Total army power: " + totalPower);
    }
}

@Getter
class Archer extends Unit {
    public Archer(int power) {
        super(power);
    }
}

@Getter
class Swordsman extends Unit {
    public Swordsman(int power) {
        super(power);
    }
}

@Getter
class Mage extends Unit {
    public Mage(int power) {
        super(power);
    }
}

@Getter
@AllArgsConstructor
class Army {
    private List<Unit> units;

    public Army(List<Unit> units) {
        this.units = units;
    }

    List<UnitThread> archers = new ArrayList<>();
    List<UnitThread> swordsmans = new ArrayList<>();
    List<UnitThread> mages = new ArrayList<>();

    public int calculateTotalPower() throws InterruptedException {
        for (Unit unit : this.units) {
            if (unit instanceof Archer) {
                UnitThread unitThread = new UnitThread(unit);
                archers.add(unitThread);
                unitThread.start();
            } else if (unit instanceof Swordsman) {
                UnitThread unitThread = new UnitThread(unit);
                swordsmans.add(unitThread);
                unitThread.start();
            } else if (unit instanceof Mage) {
                UnitThread unitThread = new UnitThread(unit);
                mages.add(unitThread);
                unitThread.start();
            }
        }
        int totalPowerArcher = 0;
        for (UnitThread archer : archers) {
            archer.join();
            totalPowerArcher += archer.getPowerTreadUnit();
        }
        int totalPowerSwordsman = 0;
        for (UnitThread swordsman : swordsmans) {
            swordsman.join();
            totalPowerSwordsman += swordsman.getPowerTreadUnit();
        }
        int totalPowerMage = 0;
        for (UnitThread mage : mages) {
            mage.join();
            totalPowerMage += mage.getPowerTreadUnit();
        }

        int archersPow = totalPowerArcher;
        int sworddsmPow = totalPowerSwordsman;
        int magePow = totalPowerMage;
        System.out.println(archersPow);
        System.out.println(sworddsmPow);
        System.out.println(magePow);
        return totalPowerArcher + totalPowerSwordsman + totalPowerMage;
    }
}

class UnitThread extends Thread {
    private Unit unit;
    @Getter
    private int powerTreadUnit;

    public UnitThread(Unit unit) {
        this.unit = unit;
    }

    @Override
    public void run() {
        powerTreadUnit = unit.getPower();
    }
}