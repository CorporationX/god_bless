package faang.school.godbless.sprint_3.multithreading.distributed_army;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private final List<Character> departments = new ArrayList<>();

    public int calculateTotalPower() {
        List<NumbersThreadProcessor> threads = new ArrayList<>();
        int result = 0;
        departments.forEach(character -> {
            NumbersThreadProcessor holder = new NumbersThreadProcessor(character);
            threads.add(holder);
            holder.start();
        });
        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        for (NumbersThreadProcessor holder : threads) {
            result += holder.getPower();
        }
        return result;
    }

    public void addUnit(Character character) {
        departments.add(character);
    }
}
