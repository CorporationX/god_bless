package faang.school.godbless.heroes;

import java.util.ArrayList;
import java.util.List;

public class Army {
    List<Entity> entityList = new ArrayList<>();

    public int calculateTotalPower() throws InterruptedException {
        int sumPower = 0;
        List<UnitThread> unitThreads = new ArrayList<>();
        for (Entity entity : entityList) {
            UnitThread unitThread = new UnitThread(entity);
            unitThreads.add(unitThread);
            unitThread.start();
            unitThread.join();
        }
        for (UnitThread unitThread : unitThreads) {
            sumPower += unitThread.getPower();
        }
        return sumPower;
    }

    public void addUnit(Entity entity) {
        entityList.add(entity);
    }
}
