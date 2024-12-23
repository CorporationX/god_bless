package school.faang.task_48255;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class Army {

    private List<Unit> units;

    public int calculateTotalPower() {

        List<PowerCalculatorThread> threads = new ArrayList<>();

        for (Unit unit : units) {
            PowerCalculatorThread thread = new PowerCalculatorThread(unit);
            threads.add(thread);
            thread.start();
        }

        int totalPower = 0;

        for (PowerCalculatorThread thread : threads) {
            try {
                thread.join();
                totalPower = totalPower + thread.getPower();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return totalPower;
    }
}
