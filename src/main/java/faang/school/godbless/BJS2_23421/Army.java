package faang.school.godbless.BJS2_23421;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Getter
public class Army {
    private final List<Unit> UNITS = new ArrayList<>();

    public int calculateTotalPower() {
        List<Unit> archers = new ArrayList<>();
        List<Unit> mages = new ArrayList<>();
        List<Unit> swordsmen = new ArrayList<>();

        for (Unit unit : UNITS) {
            if (unit instanceof Mage)
                mages.add(unit);
            if (unit instanceof Archer)
                archers.add(unit);
            if (unit instanceof Swordsman)
                swordsmen.add(unit);
        }

        var archersCalculator = new UnitPowerCalculator(archers);
        var magesCalculator = new UnitPowerCalculator(mages);
        var swordsmanCalculator = new UnitPowerCalculator(swordsmen);

        archersCalculator.start();
        magesCalculator.start();
        swordsmanCalculator.start();

        try {
            archersCalculator.join();
            magesCalculator.join();
            swordsmanCalculator.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }

        return Stream.of(archersCalculator, magesCalculator, swordsmanCalculator)
                .mapToInt(UnitPowerCalculator::getPower)
                .sum();
    }

    public void addUnit(Unit unit) {
        UNITS.add(unit);
    }
}