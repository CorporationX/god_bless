package school.faang.split3.bjs2_81159;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Army {
    private final List<Squad> army = new ArrayList<>();
    private static final List<Integer> powerOfArmy = Collections.synchronizedList(new ArrayList<>());

    public void addSquad(Squad squad) {
        army.add(squad);
    }

    public int calculateTotalPower() {
        List<Thread> calculatePowerSquadThreads = new ArrayList<>();
        for (Squad squad : army) {
            Thread thread = new Thread(() -> powerOfArmy.add(squad.calculateSquadPower()));
            calculatePowerSquadThreads.add(thread);
            thread.start();
        }
        try {
            for (Thread thread : calculatePowerSquadThreads) {
                thread.join();
            }
        } catch (Exception e) {
            System.out.println("Ожидание прервалось");
            Thread.currentThread().interrupt();
        }
        return powerOfArmy.stream().reduce(0, Integer::sum);
    }
}