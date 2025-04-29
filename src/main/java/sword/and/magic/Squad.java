package sword.and.magic;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class Squad<T extends Unit> {
    private List<T> units;

    public int calculateSquadPower() {
        return units
                .stream()
                .map(Unit::getPower)
                .reduce(0, Integer::sum);
    }
}
