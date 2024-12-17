package school.faang.sprint_1.task_armyofheroesbjs2n47795;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Army {
    private final List<Archer> archers = new ArrayList<>();
    private final List<Mage> mages = new ArrayList<>();
    private final List<Swordsman> swordsmen = new ArrayList<>();

    public int calculateTotalPower() {
        int sum = 0;
        List<PowerCalculator> powerCalculators = List.of(
                new PowerCalculator<Archer>(archers),
                new PowerCalculator<Mage>(mages),
                new PowerCalculator<Swordsman>(swordsmen)
        );

        List<Thread> threadList = new ArrayList<>();
        for (PowerCalculator powerCalculator : powerCalculators) {
            Thread thread = new Thread(powerCalculator);
            threadList.add(thread);
            thread.start();
        }

        try {
            for (Thread thread : threadList) {
                thread.join();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (PowerCalculator powerCalculator : powerCalculators) {
            sum += powerCalculator.getSum();
        }
        return sum;
    }

    public void addUnit(Warrior warrior) {
        System.out.println(warrior.getClass().getSimpleName());
        switch (warrior.getClass().getSimpleName()) {
            case "Archer" -> archers.add((Archer) warrior);
            case "Mage" -> mages.add((Mage) warrior);
            case "Swordsman" -> swordsmen.add((Swordsman) warrior);
        }
    }

    private <T extends Warrior> int calculatePower(List<T> warriors) {
        int sum = 0;
        for (Warrior warrior : warriors) {
            sum += warrior.getPower();
        }
        return sum;
    }
}
