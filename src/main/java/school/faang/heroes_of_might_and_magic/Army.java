package school.faang.heroes_of_might_and_magic;

import java.util.ArrayList;
import java.util.List;

public record Army(List<Squad> squads) {
    public int calculateTotalPower() throws InterruptedException {
        Thread[] threads = new Thread[squads.size()];
        List<CalculatePower> calculatePower = new ArrayList<>();
        for (int i = 0; i < squads.size(); i++) {
            calculatePower.add(new CalculatePower(squads.get(i)));
            threads[i] = new Thread(calculatePower.get(i));
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        return calculatePower.stream()
                .mapToInt(CalculatePower::getTotalPower)
                .sum();
    }

    public void addSquad(Squad squad) {
        squads.add(squad);
    }
}
