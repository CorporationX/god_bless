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

        return powerThreads.stream()
                .mapToInt(powerThread -> {
                    try {
                        powerThread.join();
                        return powerThread.getPower();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }).sum();
    }
}
