package school.faang.multithreading.mightandmagic;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private int fullPower = 0;
    private final List<Warrior> army = new ArrayList<>();

    public void addWarrior(Warrior warrior) {
        if(warrior.getPower() > 0) {
            army.add(warrior);
        } else {
            throw new IllegalArgumentException("power must be bigger than 0");
        }
    }

    public int calculateTotalPower() {
        List<Thread> threadList = new ArrayList<>();

        for(Warrior warrior: army) {
            Thread calculateThread = new Thread(() -> fullPower += warrior.getPower());
            threadList.add(calculateThread);
            calculateThread.start();
        }

        threadList.forEach(tread -> {
            try {
                tread.join();
            } catch(InterruptedException err) {
                throw new IllegalStateException("Поток прерван до или во время выполнения действия", err);
            }
        });

        return fullPower;
    }
}
