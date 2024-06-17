package faang.school.godbless.heroes_of_might_and_magic_distributed;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private List<Soldier> soldiers = new ArrayList<>();

    public void addUnit(@NonNull Soldier soldier) {
        soldiers.add(soldier);
    }

    public int calculateTotalPower() throws InterruptedException {
        List<Thread> threads = new ArrayList<>();
        List<Integer> power = new ArrayList<>();

        for (Soldier soldier : soldiers) {
            Thread thread = new Thread(() -> power.add(soldier.getPower()));
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        return power.stream()
                .mapToInt(num -> num)
                .sum();
    }
}
