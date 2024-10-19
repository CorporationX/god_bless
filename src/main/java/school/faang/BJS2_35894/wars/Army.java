package school.faang.BJS2_35894.wars;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Army {
    private static final Logger LOGGER = Logger.getLogger(Army.class.getName());
    private List<Unit> army = new ArrayList<>();
    private int armyDamage = 0;

    public void addUnit(Unit unit) {
        army.add(unit);
    }

    public int calculateTotalPower() throws InterruptedException {
        try {
            List<Thread> threads = new ArrayList<>();
            for (Unit unit : army) {
                int power = unit.getPower();
                Thread thread = new Thread(() -> {
                    synchronized (this) {
                        armyDamage += power;
                    }
                });
                threads.add(thread);
                thread.start();
            }

            for (Thread thread : threads) {
                thread.join();
            }

            return armyDamage;

        } catch (InterruptedException e) {
            LOGGER.log(Level.SEVERE, "Ошибка при вычислении общей силы армии", e);
            throw e;
        }
    }
}
