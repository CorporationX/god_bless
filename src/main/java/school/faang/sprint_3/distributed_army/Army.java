package school.faang.sprint_3.distributed_army;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private final List<Squad> squads = new ArrayList<>();

    public int calculateTotalPower() {
        List<SquadPowerCalculator<? extends Fighter>> calculators = new ArrayList<>();

        // Создаём и запускаем потоки
        for (Squad squad : squads) {
            SquadPowerCalculator calculator = new SquadPowerCalculator<>(squad);
            calculators.add(calculator);
            calculator.start();
        }

        for (SquadPowerCalculator<? extends Fighter> calculator : calculators) {
            try {
                calculator.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        return calculators.stream()
                .mapToInt(SquadPowerCalculator::getResult)
                .sum();
    }

    public void addSquad(Squad<? extends Fighter> squad) {
        squads.add(squad);
    }
}
