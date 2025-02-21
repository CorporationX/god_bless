package school.faang.sprint3.BJS2_61144;

import school.faang.sprint3.BJS2_61144.fighters.Fighter;

import java.util.List;
import java.util.Objects;

public class Squad<T extends  Fighter> {
    private final List<T> fighters;

    public Squad(List<T> fighters) {
        this.fighters = fighters;
    }

    public long calculateSquadPower() {
        return fighters.stream()
                .filter(Objects::nonNull)
                .mapToLong(T::getPower)
                .sum();
    }
}
