package school.faang.heroes;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
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
                log.error("Thread was interrupted", e);
            }
        }

        int totalPower = threads.stream()
                .mapToInt(ThreadPowerCalculator::getSquadPower)
                .sum();
        return totalPower;
    }
}
