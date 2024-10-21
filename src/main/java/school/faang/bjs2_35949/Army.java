package school.faang.bjs2_35949;

import java.util.*;

public class Army {
    private List<Soldier> soldierList;

    public Army() {
        this.soldierList = new ArrayList<>();
    }

    public void addSoldier(Soldier newSoldier) {
        soldierList.add(newSoldier);
    }

    public List<Soldier> getSoldierList() {
        return soldierList;
    }
    public  void addSoldier (Soldier soldierType, int count){
        for (int i = 0; i < count; i++){
            soldierList.add(soldierType);
        }
    }
    public int calculateTotalPower(int numberOfThreads) throws InterruptedException {
        int totalPower = 0;
        int size = soldierList.size();
        int step = size / numberOfThreads;
        List<SoldierPowerCalculator> calculators = new ArrayList<>();
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < numberOfThreads; i++) {
            int start = i * step;
            int end = (i == numberOfThreads - 1) ? size : (i + 1) * step;
            SoldierPowerCalculator calculator = new SoldierPowerCalculator(soldierList, start, end);
            calculators.add(calculator);

            Thread thread = new Thread(calculator);
            threads.add(thread);
            thread.start();
        }
        for (Thread threadLine : threads) {
            threadLine.join();
        }
        for (SoldierPowerCalculator calculateArmyPower : calculators) {
            totalPower += calculateArmyPower.getTotalPower();
        }
        return totalPower;
    }
}
