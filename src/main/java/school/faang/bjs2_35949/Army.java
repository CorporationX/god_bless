package school.faang.bjs2_35949;

import java.util.*;

public class Army {
    private List<Soldier> soldierList;

    public Army() {
        this.soldierList = new ArrayList<>();
    }

    public List<Soldier> getSoldierList() {
        return soldierList;
    }

    public void addSoldier(Soldier soldierType, int count) {
        for (int i = 0; i < count; i++) {
            try {
                Soldier newSoldier = soldierType.getClass().getDeclaredConstructor().newInstance();
                soldierList.add(newSoldier);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public int calculateTotalPower(int numberOfThreads) throws InterruptedException {
        int totalPower = 0;
        int size = soldierList.size();
        int step = size / numberOfThreads;
        List<SoldierPowerCalculator> calculators = new ArrayList<>();

        for (int i = 0; i < numberOfThreads; i++) {
            int start = i * step;
            int end = (i == numberOfThreads - 1) ? size : (i + 1) * step;
            SoldierPowerCalculator calculator = new SoldierPowerCalculator(soldierList, start, end);
            calculators.add(calculator);

            Thread thread = new Thread(calculator);
            thread.start();
            thread.join();
        }
        for (SoldierPowerCalculator calculateArmyPower : calculators) {
            totalPower += calculateArmyPower.getTotalPower();
        }

        return totalPower;
    }
}
