package school.faang.module3.army.entity;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

public class Squad {
    private List<Unit> units = new ArrayList<>();

    public boolean addUnit(@NonNull Unit unit) {
        return units.add(unit);
    }

    public int calculateSquadPower() {
        return units.stream()
                .reduce(0, (x, y) -> x + y.getPower(), (x, y) -> x + y);
    }
}
