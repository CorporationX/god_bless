package school.faang.heroesarmy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.List;

@Getter
@AllArgsConstructor
public class Squad {
    private List<Hero> heroes;

    public int calculateSquadPower() {
        return heroes.stream()
                .map(Hero::getPower)
                .reduce(0, Integer::sum);
    }
}
