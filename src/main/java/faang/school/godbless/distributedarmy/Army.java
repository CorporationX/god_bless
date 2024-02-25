package faang.school.godbless.distributedarmy;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class Army {

    static List<Divisions> listArmy = new ArrayList<>();

    public void add(Divisions divisions) {
        listArmy.add(divisions);
    }

    public static int calculateTotalPower() throws InterruptedException {
        List<DivisionPowerThread> magesPowerThreads = new ArrayList<>();
        List<DivisionPowerThread> archersPowerThreads = new ArrayList<>();
        List<DivisionPowerThread> swordsmansPowerThreads = new ArrayList<>();

        for (Divisions divisions : listArmy) {
            if (divisions.isMage()) {
                startThread(divisions, magesPowerThreads);
            }
            if (divisions.isArcher()) {
                startThread(divisions, archersPowerThreads);
            }
            if (divisions.isSwordsman()) {
                startThread(divisions, swordsmansPowerThreads);
            }
        }

        int totalPowerArchers = getPowerSum(archersPowerThreads);
        int totalPowerMages = getPowerSum(magesPowerThreads);
        int totalPowerSwordsman = getPowerSum(swordsmansPowerThreads);

        System.out.println("Power archers = " + totalPowerArchers);
        System.out.println("Power mages = " + totalPowerMages);
        System.out.println("Power swordsman = " + totalPowerSwordsman);
        return totalPowerArchers + totalPowerMages + totalPowerSwordsman;
    }

    private static void startThread(Divisions divisions, List<DivisionPowerThread> powerThreads) {
        DivisionPowerThread divisionPowerThread = new DivisionPowerThread(divisions);
        powerThreads.add(divisionPowerThread);
        divisionPowerThread.start();
    }

    private static int getPowerSum(List<DivisionPowerThread> divisions) throws InterruptedException {
        int totalPowerDevision = 0;
        for (DivisionPowerThread divisonThread : divisions) {
            divisonThread.join();
            totalPowerDevision += divisonThread.getPower();
        }
        return totalPowerDevision;
    }


}
