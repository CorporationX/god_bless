package faang.school.godbless.parallelismAndThread.armyOfHeroes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Army {
    private List<Unit> unitList;

    public Army() {
        unitList = new ArrayList<>();
    }

    public void addUnit(Unit unit) {
        unitList.add(unit);
    }

    public int calculateTotalPower() {
        List<CalculateThread> threadList = new ArrayList<>();
        for (Unit unit : unitList) {
            threadList.add(new CalculateThread(unit));
        }

        threadList.forEach(thread -> {
            thread.start();
            System.out.println("Поток " + thread.getName() + " запущен!");
        });

        int summ = 0;
        for (CalculateThread calculateThread : threadList) {
            try {
                calculateThread.join();
                summ += calculateThread.getPower();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        return summ;
    }
}
