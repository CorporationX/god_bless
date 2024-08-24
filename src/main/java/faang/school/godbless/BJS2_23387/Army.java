package faang.school.godbless.BJS2_23387;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class Army {
    List<Unit> allUnits;

    public int calculateTotalPower() {
        List<PowerThread> powerThreads = new ArrayList<>();
        allUnits.forEach(unit -> powerThreads.add(new PowerThread(unit)));
        powerThreads.forEach(Thread::start);

        int totalPower = 0;
        for (PowerThread powerThread : powerThreads) {
            try {
                powerThread.join();
                totalPower += powerThread.getPower();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return totalPower;
    }
}
