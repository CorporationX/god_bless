package school.faang.bjs2_81042.divisions;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private final List<Squad> squads = new ArrayList<>();

    public void addSquad(Squad squad) {
        squads.add(squad);
    }

    public int calculateTotalPower() throws InterruptedException {
        List<Integer> squadPowers = new ArrayList<>();
        for (Squad squad : squads) {
            Thread squadThread = new Thread(() -> squadPowers.add(squad.calculateSquadPower()));
            squadThread.start();
            squadThread.join();
        }
        return squadPowers.stream().mapToInt(Integer::intValue).sum();
    }
}
