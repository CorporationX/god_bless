package school.faang.task61254.service;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Army {
    @Getter
    private final List<Squad<?>> squads;

    public Army() {
        this.squads = new ArrayList<>();
    }

    public void addSquad(Squad<?> squad) {
        squads.add(squad);
    }

    public int calculateTotalPower() {
        List<SquadPowerCalculator> threads = squads.stream()
                .map(SquadPowerCalculator::new)
                .toList();
        threads.forEach(Thread::start);

        int totalPower = 0;
        for (SquadPowerCalculator thread : threads) {
            try {
                thread.join();
                totalPower += thread.getSquadPower();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Прерывание во время ожидания завершения потока: " + e.getMessage());
            }
        }
        return totalPower;
    }

    private static class SquadPowerCalculator extends Thread {
        private final Squad<?> squad;
        @Getter
        private int squadPower;

        public SquadPowerCalculator(Squad<?> squad) {
            this.squad = squad;
        }

        @Override
        public void run() {
            squadPower = squad.calculateSquadPower();
        }
    }
}