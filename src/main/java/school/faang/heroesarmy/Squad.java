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
                .mapToInt(Hero::getPower)
                .sum();
    }
}
