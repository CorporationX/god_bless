package school.faang.sprint_3.bjs2_35887_distributedArmyHomm;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private final List<Unit> army = new ArrayList<>();

    public int calculateTotalPower() {
        List<Integer> unitsPower = new ArrayList<>();
        List<Thread> threads = new ArrayList<>();

        army.forEach(unit -> {
            Thread thread = new Thread(new PowerCalculator(unit, unitsPower));
            threads.add(thread);
            thread.start();
        });

        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
                throw new RuntimeException("Текущий поток был прерван во время ожидания другого потока", e);
            }
        });

        return unitsPower.stream()
                .mapToInt(i -> i)
                .sum();
    }

    public void addUnit(Unit unit) {
        army.add(unit);
    }
}
