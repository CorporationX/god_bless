package school.faang.bjs2_81036_thread_heroes;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@NoArgsConstructor
public class Army {
    private final List<Squad<? extends Soldier>> squads = new ArrayList<>();

    @Getter
    private static class SquadPowerThread extends Thread {
        private int squadPower;
        private final Squad<? extends Soldier> squad;

        public SquadPowerThread(Squad<? extends Soldier> squad) {
            this.squad = squad;
        }

        @Override
        public void run() {
            squadPower = squad.calculateSquadPower();
        }
    }

    public boolean addSquad(@NonNull Squad<? extends Soldier> squad) {
        return squads.add(squad);
    }

    public int calculateTotalPower() {
        if (squads.isEmpty()) {
            return 0;
        }

        List<SquadPowerThread> threads = new ArrayList<>();
        squads.forEach(squad -> {
            SquadPowerThread thread = new SquadPowerThread(squad);
            threads.add(thread);
            thread.start();
        });

        try {
            for (Thread thread : threads) {
                thread.join();
            }
        } catch (Exception e) {
            Thread.currentThread().interrupt();
            log.error("Calculate total power failed. Interrupt exception: {}", e.getMessage());
        }

        return threads.stream()
                .mapToInt(SquadPowerThread::getSquadPower)
                .sum();
    }
}
