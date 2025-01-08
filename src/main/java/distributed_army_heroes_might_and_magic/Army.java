package distributed_army_heroes_might_and_magic;

import java.util.ArrayList;
import java.util.List;

public class Army {

    public List<Unit> listArmy = new ArrayList<>();

    public void addUnit(Unit unit) {
        listArmy.add(unit);
    }


    public int calculateTotalPower() {
        List<PowerThread> threads = listArmy.stream()
                .map(PowerThread::new)
                .peek(PowerThread::start)
                .toList();

        for (PowerThread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        return threads.stream()
                .mapToInt(PowerThread::getPower)
                .sum();
    }
}