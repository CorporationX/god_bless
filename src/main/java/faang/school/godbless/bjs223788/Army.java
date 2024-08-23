package faang.school.godbless.bjs223788;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Data
public class Army {
    private final List<Unit> units;
    private List<PowerCalculatorThread> threads = new ArrayList<>();

    public int calculateTotalPower() {
        int totalPower = 0;
        for (var unit : units) {
            PowerCalculatorThread powerCalculatorThread = new PowerCalculatorThread(unit);
            this.threads.add(powerCalculatorThread);
            powerCalculatorThread.start();
        }
        for (var thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }

            totalPower += thread.getTotalPower();
        }
        return totalPower;
    }
}