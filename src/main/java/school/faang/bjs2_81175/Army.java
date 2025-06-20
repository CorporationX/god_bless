package school.faang.bjs2_81175;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@NoArgsConstructor
public class Army {
    private final List<Squad> squads = new ArrayList<>();

    @Getter
    private static class SquadPower extends Thread {
        private int squadPower;
        private final Squad squad;

        public SquadPower(Squad squad) {
            this.squad = squad;
        }

        @Override
        public void run() {
            squadPower = squad.calculateSquadPower();
        }
    }

    public boolean addSquad(Squad squad) {
        return squads.add(squad);
    }

    public int calculateTotalPower() {
        if (squads.isEmpty()) {
            return 0;
        }

        List<SquadPower> threads = new ArrayList<>();
        squads.forEach(squad -> {
            SquadPower thread = new SquadPower(squad);
            threads.add(thread);
            thread.start();
        });

        try {
            for (Thread thread : threads) {
                thread.join();
            }
        } catch (Exception e) {
            Thread.currentThread().interrupt();
            System.out.println("Меня прервали " + e.getMessage());
        }

        return threads.stream()
                .mapToInt(SquadPower::getSquadPower)
                .sum();
    }

}
