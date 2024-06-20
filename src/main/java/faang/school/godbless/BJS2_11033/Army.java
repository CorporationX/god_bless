package faang.school.godbless.BJS2_11033;

import java.util.ArrayList;
import java.util.List;

public class Army {
    List<Warrior> warriors = new ArrayList<>();
    List<CalculateThread> threads = new ArrayList<>();

    public int calculateTotalPower() {
        warriors.forEach(warrior -> {
            CalculateThread calculateThread = new CalculateThread(warrior);
            calculateThread.start();
            threads.add(calculateThread);
        });
        return threads.stream().mapToInt(CalculateThread::getPower).sum();
    }

    public void addUnit(Warrior warrior) {
        warriors.add(warrior);
    }
}
