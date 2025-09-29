package school.faang.bjs2_91490.army;

import school.faang.bjs2_91490.fighters.Fighter;

import java.util.List;

public record Squad<T extends Fighter>(String name, List<T> fighters) {
    public int calculateSquadPower() {
        return fighters.stream().mapToInt(Fighter::getPower).sum();
    }
}