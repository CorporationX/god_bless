package school.faang.distributed_army;

import java.util.ArrayList;
import java.util.List;

public class Squad<T extends Fighter> {
    private final List<T> squad = new ArrayList<>();

    public int calculateSquadPower() {
        return squad.stream()
                .mapToInt(Fighter::getPower)
                .sum();
    }
}
