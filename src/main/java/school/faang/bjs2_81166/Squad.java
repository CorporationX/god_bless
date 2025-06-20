package school.faang.bjs2_81166;

import java.util.List;

public class Squad<T extends Fighter> {
    private final List<T> fighters;

    public Squad(List<T> fighters) {
        this.fighters = fighters;
    }

    public int calculateTotalPower() {
        return fighters.stream().mapToInt(Fighter::getPower).sum();
    }
}
