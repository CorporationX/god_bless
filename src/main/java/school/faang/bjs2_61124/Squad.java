package school.faang.bjs2_61124;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class Squad {
    @Getter
    private final String name;
    private final List<Warrior> warriors;

    public int calculateSquadPower() {
        return warriors.stream()
                .mapToInt(Warrior::getPower)
                .sum();
    }
}
