package school.faang.distributedarmy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class Army {
    private final List<Unit> allFighters= Collections.synchronizedList(new ArrayList<>());
    public static int result = 0;

    public void addUnit(Unit unit) {
        if (unit != null) {
            allFighters.add(unit);
        }
    }

    public int calculateTotalPower() throws Exception {
        Thread[] threads = new Thread[allFighters.size()];
        for (int i = 0; i < allFighters.size(); i++) {
            threads[i] = new ThreadArm(allFighters.get(i));
        }
        Arrays.stream(threads).forEach(Thread::start);
        for (Thread tr : threads) {
            tr.join();
        }
        return result;
    }
}
