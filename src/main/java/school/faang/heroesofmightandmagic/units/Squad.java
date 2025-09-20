package school.faang.heroesofmightandmagic.units;

import lombok.AllArgsConstructor;
import school.faang.heroesofmightandmagic.fighters.Fighter;

import java.util.List;

@AllArgsConstructor
public class Squad {
    private String name;
    private List<Fighter> squad;

    public int calculateSquadPower() {
        return squad.stream().mapToInt(Fighter::getPower).sum();
    }
}
