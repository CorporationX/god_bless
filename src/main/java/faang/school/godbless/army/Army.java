package faang.school.godbless.army;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private static final List<Warrior> HEROES = new ArrayList<>();

    public void addUnit(@NonNull Warrior warrior) {
        HEROES.add(warrior);
    }

    public int calculateTotalPower() throws InterruptedException {
        int totalPower = 0;
        List<PowerThread> threads = new ArrayList<>();
        for (Warrior warrior : HEROES) {
            PowerThread thread = new PowerThread(warrior);
            thread.start();
            threads.add(thread);
        }
        for (PowerThread thread : threads) {
            thread.join();
            totalPower += thread.getPower();
        }
        return totalPower;
    }
}
