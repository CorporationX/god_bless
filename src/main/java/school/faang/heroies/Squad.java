package school.faang.heroies;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Squad {
    private String squadName;
    private List<Hero> squad;
    private int totalSquadPower;

    public Squad(String squadName, List<Hero> squad) {
        this.squadName = squadName;
        this.squad = squad;
    }

    public int calculateSquadPower() {
        squad.forEach(hero -> totalSquadPower += hero.getPower());
        return totalSquadPower;
    }
}
