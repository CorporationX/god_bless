package school.faang.bjs2_61300;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Squad {

    private List<Unit> fighters = new ArrayList<>();
    private final String units;

    public Squad(String units, List<Unit> fightes) {
        this.units = units;
        this.fighters = fightes;
    }

    public int calculateSquadPower() {
        return fighters.stream().mapToInt(Unit::getPower).sum();
    }
}