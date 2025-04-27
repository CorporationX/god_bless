package school.faang.heroes_of_might_and_magic;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
class Squad {
    private List<Fighter> fighters;

    public Squad(List<Fighter> fighters) {
        this.fighters = fighters;
    }

    public int calculateSquadPower() {
        return fighters.stream()
                .mapToInt(Fighter::getPower)
                .sum();
    }
}