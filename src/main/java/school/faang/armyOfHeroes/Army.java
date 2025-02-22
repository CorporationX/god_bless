package school.faang.armyOfHeroes;

import java.util.ArrayList;
import java.util.List;

public class Army {

    private List<Squad> squads = new ArrayList<>();

    public void addSquad(Squad squad) {
        squads.add(squad);
    }

    public int calculateTotalPower() throws InterruptedException {
        Thread[] threads = new Thread[squads.size()];
        int i = 0;
        for (Squad squad : squads) {
            threads[i] = new Thread(squad::calculateSquadPower);
            threads[i].start();
            i++;
        }
        for (Thread thread : threads) {
            thread.join();
        }

        for (Squad squad : squads) {
            System.out.printf("Total power of %s is %d%n", squad.getName(), squad.getTotalPower());
        }
        return squads.stream().mapToInt(Squad::getTotalPower).sum();
    }
}
