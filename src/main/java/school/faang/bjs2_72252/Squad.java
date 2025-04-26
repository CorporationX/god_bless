package school.faang.bjs2_72252;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

@Data
@NoArgsConstructor
public class Squad implements Callable<Integer> {

    private List<UnitClass> units = new ArrayList<>();

    public int calculateSquadPower() {
        return units.stream().map(unit -> unit.power).reduce(0, Integer::sum);
    }

    @Override
    public Integer call() {
        return calculateSquadPower();
    }

    public void addUnit(UnitClass unit, int times) {
        for (int i = 0; i < times; i++) {
            this.units.add(unit);
        }
    }
}
