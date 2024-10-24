package school.faang.bjs2_35949;

import java.util.*;

public class SoldierPowerCalculator implements Runnable {
    private List<Soldier> soldierList;
    private int startIndex;
    private int endIndex;
    private int totalPower;

    public SoldierPowerCalculator(List<Soldier> soldierList, int startIndex, int endIndex) {
        this.soldierList = soldierList;
        this.endIndex = endIndex;
        this.startIndex = startIndex;
        this.totalPower = 0;
    }

    @Override
    public void run() {
        for (int i = startIndex; i < endIndex; i++) {
            totalPower += soldierList.get(i).getPower();
        }
    }

    public int getTotalPower() {
        return totalPower;
    }
}

