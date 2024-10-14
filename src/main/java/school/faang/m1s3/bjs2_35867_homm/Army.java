package school.faang.m1s3.bjs2_35867_homm;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class Army {

    private List<Creature> army = new ArrayList<>();

    public void addUnit(Creature creature) {
        army.add(creature);
    }

    public int calculateTotalPower() {
        Map<Creature, Integer> unitsPower = new HashMap<>();
        List<Thread> threads = new ArrayList<>();

        for (Creature creature : army) {
            Thread thread = new Thread(new Calculator(creature, unitsPower));
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return unitsPower.entrySet().stream().mapToInt(Map.Entry::getValue).sum();
    }
}
