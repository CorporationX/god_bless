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

        threadList.forEach(calculateThread -> {
            try {
                calculateThread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        return threadList.stream()
                .map(CalculateThread::getPower)
                .reduce(0, Integer::sum);

        //Почему нельзя сделать так? Ругается на summ + thread.getPower()
        //return threadList.stream()
        //        .reduce(0, (summ, thread) -> summ + thread.getPower());

    }
}
