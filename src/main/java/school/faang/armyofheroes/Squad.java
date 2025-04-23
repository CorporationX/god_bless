package school.faang.armyofheroes;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class Squad<T extends Hero> {
    @NonNull
    private final List<T> heroes;

    public int calculateSquadPower() {
        return heroes.stream()
                .mapToInt(Hero::getPower)
                .sum();
    }
}
