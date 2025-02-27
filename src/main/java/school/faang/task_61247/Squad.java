package school.faang.task_61247;

import lombok.RequiredArgsConstructor;
import school.faang.task_61247.character.Unit;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class Squad<T extends Unit> {
    private final List<T> units = new ArrayList<>();

    public void addUnit(T unit) {
        units.add(unit);
    }

    public int calculateSquadPower() {
        return units.stream()
                .mapToInt(T::getPower)
                .sum();
    }
}
