package school.faang.rpg;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Army {
    private final List<Squad> squads = new ArrayList<>();

    public void addSquad(Squad squad) {
        squads.add(squad);
    }

    public int calculateTotalPower() throws InterruptedException {
        List<SquadPowerCalculator> threads = new ArrayList<>();

        for (Squad squad : squads) {
            SquadPowerCalculator calculator = new SquadPowerCalculator(squad);
            threads.add(calculator);
            calculator.start();
        }

        int total = 0;
        for (SquadPowerCalculator thread : threads) {
            thread.join();
            total += thread.getPower();
        }

        return total;
    }
}
