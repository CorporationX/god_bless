package faang.school.godbless.BJS223663;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private final List<Object> units = new ArrayList<>();

    public void addUnit(Object unit) {
        units.add(unit);
    }

    public int calculateTotalPower() {
        List<Thread> threads = new ArrayList<>();
        List<Integer> powers = new ArrayList<>();

        for (Object unit : units) {
            Thread thread = new Thread(() -> {
                int power = 0;
                if (unit instanceof Archer) {
                    power = ((Archer) unit).getPower();
                } else if (unit instanceof Swordsman) {
                    power = ((Swordsman) unit).getPower();
                } else if (unit instanceof Mage) {
                    power = ((Mage) unit).getPower();
                } else if (unit instanceof Pudge) {
                    power = ((Pudge) unit).getPower();
                } else if (unit instanceof Dragon) {
                    power = ((Dragon) unit).getPower();
                }
                synchronized (powers) {
                    powers.add(power); // Добавляем рассчитанную силу в список powers
                }
            });
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
//                e.printStackTrace();
            }
        }

        return powers.stream().mapToInt(Integer::intValue).sum();
    }

}
