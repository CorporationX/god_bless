package school.faang.stream3.distributedmarmymnm;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Army {

    private final List<Squad> squadList = new ArrayList<>();

    public void addSquad(Squad squad) {
        squadList.add(squad);
    }

    @SneakyThrows
    public int calculateTotalPower() {
        Set<Thread> allThreads = new HashSet<>();
        for (Squad squad : squadList) {
            Thread thread = new SquadPowerCalculator(squad);
            thread.start();
            allThreads.add(thread);
        }
        for (Thread thread : allThreads) {
            thread.join();
        }
        int totalPower = 0;
        for (Squad squad : squadList) {
            totalPower += squad.calculateSquadPower();
        }
        return totalPower;
    }

}
