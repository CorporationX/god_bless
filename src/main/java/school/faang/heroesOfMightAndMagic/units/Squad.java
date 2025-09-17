package school.faang.heroesOfMightAndMagic.units;

import lombok.AllArgsConstructor;
import school.faang.heroesOfMightAndMagic.fighters.Fighter;

import java.util.List;

@AllArgsConstructor
public class Squad {
    private String name;
    private List<Fighter> squad;

    public int calculateSquadPower() {
        return squad.stream().mapToInt(Fighter::getPower).sum();
    }
}
