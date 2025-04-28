package school.faang.distributed_army;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class Squad<T extends Fighter> {
    private final List<T> squad;

    public int calculateSquadPower() {
        return squad.stream()
                .mapToInt(Fighter::getPower)
                .sum();
    }
}
