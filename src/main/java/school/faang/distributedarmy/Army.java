package school.faang.distributedarmy;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private final List<Squad> squads = new ArrayList<>();

    public void addSquad(Squad squad) {
        squads.add(squad);
    }

    public int calculateTotalPower() throws ArmyException {
        List<CalculationThread> threads = new ArrayList<>();

        for (Squad squad : squads) {
            CalculationThread thread = new CalculationThread(squad);
            threads.add(thread);
            thread.start();
        }

        int totalPower = 0;

        try {
            for (CalculationThread thread : threads) {
                thread.join();
                totalPower += thread.getSquadPower();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new ArmyException("Вычисление общей силы армии было прервано", e);
        }

        return totalPower;
    }
}
