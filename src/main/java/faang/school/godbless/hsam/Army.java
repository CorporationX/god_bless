package faang.school.godbless.hsam;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Army {
    private final List<Unit> army = new ArrayList<>();

    public void addUnit(Unit unit) {
        army.add(unit);
    }

    public int calculateTotalPower() {
        ExecutorService poolThreads = Executors.newFixedThreadPool((int) army.stream()
                .count());

        int sun = 0;
        for (Unit unit : army) {
            PowerThread powerThread = new PowerThread(unit);
            poolThreads.submit(powerThread);
        }
        return 0;
    }
}
 