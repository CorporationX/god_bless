package faang.school.godbless.thirdSprint.DistributedArmy;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.List;

public class Army {
    private List<Archer> archers = new ArrayList<>();
    private List<Swordsman> swordsmen = new ArrayList<>();
    private List<Mage> mages = new ArrayList<>();

    public void addUnit(Archer archer) {
        archers.add(archer);
    }

    public void addUnit(Swordsman swordsman) {
        swordsmen.add(swordsman);
    }

    public void addUnit(Mage mage) {
        mages.add(mage);
    }

    public int calculateTotalPower() {
        AtomicInteger totalArmyPower = new AtomicInteger(0);

        Thread archersThread = new Thread(() -> {
            int totalArchersPower = calculateTotalPower(archers);
            System.out.println("Общая сила всех лучников: " + totalArchersPower);
            totalArmyPower.addAndGet(totalArchersPower);
        });
        archersThread.start();

        Thread swordsmenThread = new Thread(() -> {
            int totalSwordsmenPower = calculateTotalPower(swordsmen);
            System.out.println("Общая сила всех мечников: " + totalSwordsmenPower);
            totalArmyPower.addAndGet(totalSwordsmenPower);
        });
        swordsmenThread.start();

        Thread magesThread = new Thread(() -> {
            int totalMagesPower = calculateTotalPower(mages);
            System.out.println("Общая сила всех магов: " + totalMagesPower);
            totalArmyPower.addAndGet(totalMagesPower);
        });
        magesThread.start();

        try {
            archersThread.join();
            swordsmenThread.join();
            magesThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return totalArmyPower.get();
    }

    public <T extends Unit> int calculateTotalPower(List<T> units) {
        return units.stream()
                .map(Unit::getPower)
                .reduce(0, Integer::sum);
    }
}
