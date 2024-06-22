package faang.school.godbless.sprint3.armyOfSwordsAndMagicHeroes;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Army {

    List<ArmyItem> army;

    public Army(List<ArmyItem> army) {
        this.army = army;
    }

    public Integer calculateTotalPower() {

            List<CalculateRunnable> calculateRunnableList = new ArrayList<>();
            List<Thread> threadList = new ArrayList<>();

            army.forEach(armyItem -> {
                CalculateRunnable calculateRunnable = new CalculateRunnable(armyItem);
                Thread thread = new Thread(calculateRunnable);
                calculateRunnableList.add(calculateRunnable);
                threadList.add(thread);
                thread.start();
            });

            threadList.forEach(thread -> {
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });

            Integer result = calculateRunnableList.stream()
                    .map(CalculateRunnable::getPower)
                    .reduce(0, Integer::sum);

            return result;
    }
}
