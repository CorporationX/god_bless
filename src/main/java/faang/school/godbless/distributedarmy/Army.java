package faang.school.godbless.distributedarmy;

import java.util.ArrayList;
import java.util.List;

public class Army {

    private final List<Division> listArmy;

    Army() {
        listArmy = new ArrayList<>();
    }

    public void add(Division divisions) {
        listArmy.add(divisions);
    }

    public int calculateTotalPower() throws InterruptedException {
        List<DivisionPowerThread> armyPowerThreads = new ArrayList<>();
        listArmy.stream().map(DivisionPowerThread::new).forEach(divisionPowerThread -> {
            armyPowerThreads.add(divisionPowerThread);
            divisionPowerThread.start();
        });
        return getPowerSum(armyPowerThreads);
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