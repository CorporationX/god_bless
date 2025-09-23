package school.faang.m1.thread.army;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Army {

    private final List<Squad<? extends Unit>> squadList = new ArrayList<>();

    public void addSquad(Squad<? extends Unit> squad) {
        if (squad != null) {
            squadList.add(squad);
        }
    }

    public int calculateTotalPower() {
        if (squadList.isEmpty()) {
            return 0;
        }

        final int n = squadList.size();
        final int[] partial = new int[n];
        List<Thread> threads = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            final int idx = i;
            Thread t = new Thread(() ->
                    partial[idx] = calculateSquadPower(squadList.get(idx)), "SquadPower-" + idx);
            threads.add(t);
            t.start();
        }

        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException("Interrupted while waiting squad threads", e);
            }
        }

        int total = 0;
        for (int p : partial) {
            total += p;
        }
        return total;
    }

    private static int calculateSquadPower(Squad<? extends Unit> squad) {
        if (squad == null) {
            return 0;
        }
        return squad.getSquad().stream()
                .filter(Objects::nonNull)
                .mapToInt(Unit::getPower)
                .sum();
    }
}
