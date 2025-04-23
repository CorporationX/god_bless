package school.faang.armyofheroes;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class Squad {
    @NonNull
    private final List<Hero> heroes;

    public int calculateSquadPower() {
        return heroes.stream()
                .mapToInt(Hero::getPower)
                .sum();
    }
}
