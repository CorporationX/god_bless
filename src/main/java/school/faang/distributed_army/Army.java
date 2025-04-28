package school.faang.distributed_army;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private final List<Squad> squads = new ArrayList<>();

    public int calculateTotalPower() {
        List<SquadPowerCalculator<? extends Fighter>> calculators = new ArrayList<>();

        // Создаём и запускаем потоки
        for (Squad<? extends Fighter> squad : squads) {
            SquadPowerCalculator<? extends Fighter> calculator = new SquadPowerCalculator<>(squad);
            calculators.add(calculator);
            calculator.start();
        }

        // Ждём завершения всех потоков
        for (SquadPowerCalculator<? extends Fighter> calculator : calculators) {
            try {
                calculator.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        // Суммируем результаты
        return calculators.stream()
                .mapToInt(SquadPowerCalculator::getResult)
                .sum();
    }
}
