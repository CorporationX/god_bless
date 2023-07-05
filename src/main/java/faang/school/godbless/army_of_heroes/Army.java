package faang.school.godbless.army_of_heroes;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class Army {

    private List<Unit> units;

    public String calculateTotalPower() {
        List<ManagerThread> managerThreads = new ArrayList<>();
        for (Unit unit : units) {
            ManagerThread managerThread = new ManagerThread(unit);
            managerThreads.add(managerThread);
            managerThread.start();
        }

        for (ManagerThread managerThread : managerThreads) {
            try {
                managerThread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        int totalPower = 0;
        for (ManagerThread managerThread : managerThreads) {
            System.out.println(managerThread.getName() + " calculated the power of the detachment " + managerThread.getNameUnit() + " : " + managerThread.getPower());
            totalPower += managerThread.getPower();
        }
        return "Total power is " + totalPower;
    }
}
