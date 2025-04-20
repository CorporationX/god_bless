package school.faang.heroes;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Army {
    private final List<Squad<? extends Fighter>> squads = new ArrayList<>();

    public void addSquad(Squad<? extends Fighter> squad) {
        squads.add(squad);
    }

    public int calculateTotalPower() {
        List<ThreadPowerCalculator> threads = new ArrayList<>();
        for (Squad<? extends Fighter> squad : squads) {
            ThreadPowerCalculator thread = new ThreadPowerCalculator(squad);
            thread.start();
            threads.add(thread);
        }

        for (ThreadPowerCalculator thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        int totalPower = threads.stream()
                .mapToInt(ThreadPowerCalculator::getSquadPower)
                .sum();
        return totalPower;
    }
}
