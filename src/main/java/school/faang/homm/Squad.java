package school.faang.homm;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Squad {
    private List<Unit> units;

    public Squad(List<Unit> units) {
        this.units = units;
    }

    public int calculateSquadPower() {
        return units.stream().map(Unit::getPower).reduce(Integer::sum).get();
    }
}
