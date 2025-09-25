package school.faang.bjs2_91505;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private final List<Squad> squads = new ArrayList<>();

    public void addSquad(Squad squad) {
        squads.add(squad);
    }

    public int calculateTotalPower() throws InterruptedException {
        List<SquadPowerCalculator> threads = new ArrayList<>();

        for (Squad squad : squads) {
            SquadPowerCalculator thread = new SquadPowerCalculator(squad);
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        return threads.stream()
                .mapToInt(SquadPowerCalculator::getResult)
                .sum();
    }

}
