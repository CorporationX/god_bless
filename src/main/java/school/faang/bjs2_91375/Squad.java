package school.faang.bjs2_91375;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class Squad<T extends Warrior> {
    private final String name;
    private final List<T> warriors;

    public int calculateSquadPower() {
        return warriors.stream().reduce(0, (a, b) -> a + b.getPower(), Integer::sum);
    }
}
