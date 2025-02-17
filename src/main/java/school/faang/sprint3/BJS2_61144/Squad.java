package school.faang.sprint3.BJS2_61144;

import school.faang.sprint3.BJS2_61144.fighters.Fighter;

import java.util.List;

public class Squad<T extends  Fighter> {
    private final List<T> fighters;

    public Squad(List<T> fighters) {
        this.fighters = fighters;
    }

    public long calculateSquadPower() {
        return fighters.stream().mapToLong(T::getPower).sum();
    }
}
