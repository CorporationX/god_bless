package BJS2_23424_HoMM_Multithreading;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
@AllArgsConstructor
public class Army {
    private static final int NUMBER_OF_THREADS = 3;
    private static final List<List<Unit>> units = new ArrayList<>();
    private static final List<Unit> archers = new ArrayList<>();
    private static final List<Unit> swordsmen = new ArrayList<>();
    private static final List<Unit> mages = new ArrayList<>();


    public static void main(String[] args) throws InterruptedException {
        addUnit(new Archer("Archer", 20));
        addUnit(new Swordsman("Swordsman", 30));
        addUnit(new Mage("Mage", 60));
        addUnit(new Mage("Mage", 70));
        units.add(archers);
        units.add(swordsmen);
        units.add(mages);

        AtomicInteger allArmyPower = new AtomicInteger();
        Thread[] threads = new Thread[NUMBER_OF_THREADS];
        int chunkSize = units.size() / NUMBER_OF_THREADS;

        for (int i = 0; i < NUMBER_OF_THREADS; i++) {
            int start = i * chunkSize;
            int end = (i == NUMBER_OF_THREADS - 1) ? units.size() : (i + 1) * chunkSize;

            threads[i] = new Thread(() -> {
                for (int j = start; j < end; j++) {
                    List<Unit> squads = units.get(j);
                    int squadPower = calculateTotalPower(squads);
                    allArmyPower.addAndGet(squadPower);
                    System.out.println(squads.get(0).getUnitSquadName() + " has " + squadPower);
                }
            });
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("Full army power now is: " + allArmyPower);
    }

    public static int calculateTotalPower(List<Unit> units) {
        int sumPower = 0;
        for (Unit unit : units) {
            sumPower += unit.getPower();
        }
        return sumPower;
    }

    public static void addUnit(Unit unit) {
        if (unit instanceof Archer) {
            archers.add(unit);
        } else if (unit instanceof Mage) {
            mages.add(unit);
        } else if (unit instanceof Swordsman) {
            swordsmen.add(unit);
        }
    }
}
