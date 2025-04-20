package school.faang.bjs2_72141;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Getter
public class Squad {
    private final List<Warrior> squad;

    public Integer calculateSquadPower() {
        return this.squad.stream()
                .mapToInt(Warrior::getPower)
                .sum();
    }
}
