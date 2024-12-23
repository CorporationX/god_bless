package school.faang.sprint_3.task_47956;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Army {
    private List<Unit> units = new ArrayList<>();

    public void addUnit(Unit unit) {
        units.add(unit);
    }

    public int calculateTotalPower() throws InterruptedException {
        List<Unit> archers = units.stream()
                .filter(unit -> unit instanceof Archer)
                .collect(Collectors.toList());
        List<Unit> swordsman = units.stream()
                .filter(unit -> unit instanceof Swordsman)
                .collect(Collectors.toList());
        List<Unit> mages = units.stream()
                .filter(unit -> unit instanceof Mage)
                .collect(Collectors.toList());

        PowerCalculatorThread archerThread = new PowerCalculatorThread(archers);
        PowerCalculatorThread swordsmanThread = new PowerCalculatorThread(swordsman);
        PowerCalculatorThread magesThread = new PowerCalculatorThread(mages);

        archerThread.start();
        swordsmanThread.start();
        magesThread.start();

        archerThread.join();
        swordsmanThread.join();
        magesThread.join();

        int totalPower = archerThread.getTotalPower() + swordsmanThread.getTotalPower() + magesThread.getTotalPower();

        System.out.println("Общая сила лучников: " + archerThread.getTotalPower());
        System.out.println("Общая сила мечников: " + swordsmanThread.getTotalPower());
        System.out.println("Общая сила магов: " + magesThread.getTotalPower());
        System.out.println("Общая сила армии: " + totalPower);

        return totalPower;
    }
}
