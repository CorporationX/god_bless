package school.faang.sprint3.multithreading.bjs2_61400;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Army {
    private final List<Squad> squads;
    private final List<Thread> threads;


    public Army(List<Squad> squads) {
        this.squads = squads;
        threads = new ArrayList<>();
    }

    public int calculateTotalPower() throws InterruptedException {
        for (var squad : squads) {
            Thread thread = new Thread(squad);
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
        int totalArmyPower = squads.stream().mapToInt(Squad::getTotalSquadPower).sum();
        return totalArmyPower;
    }
}
