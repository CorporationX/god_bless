package faang.school.godbless.Sprint_4.Multithreading_Parallelism.DistributedArmyOfHMM;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class Army {
    private List<Unit> division = new ArrayList<>();

    public void addUnit(Unit unit) {
        division.add(unit);
    }

    public int calculateTotalPower() {
        AtomicInteger totalPower = new AtomicInteger();
        List<CalculatorOfPower> threads = new ArrayList<>();
        for (Unit unit: division){
            CalculatorOfPower thread = new CalculatorOfPower(unit);
            thread.start();
            threads.add(thread);
        }
        threads.stream()
                .forEach(thread -> {
                    try {
                        thread.join();
                        totalPower.addAndGet(thread.getUnitPower());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
        return totalPower.get();
    }
}
