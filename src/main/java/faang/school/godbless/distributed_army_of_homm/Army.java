package faang.school.godbless.distributed_army_of_homm;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;

public class Army {
    List<Unit> units = new ArrayList<>();

    public void addUnit(Unit unit) {
        units.add(unit);
    }

    @SneakyThrows
    public int calculateTotalPower() {
        List<UnitTread> threads = new ArrayList<>();
        for(Unit unit : units) {
            UnitTread thread = new UnitTread(unit);
            threads.add(thread);
            thread.start();
        }

        int sum = 0;
        for(UnitTread thread : threads) {
            thread.join();
            sum = sum + thread.getUnitPower();
        }
        return sum;
    }
}
