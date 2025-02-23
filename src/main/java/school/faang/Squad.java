package school.faang;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
public class Squad {
    private final List<Unit> units = new ArrayList<>();


    public void addUnit(Unit unit) {
        units.add(unit);
    }

    public int calculateTotalPower() {
        return units.stream()
                .mapToInt(Unit::getPower)
                .sum();
    }
}
