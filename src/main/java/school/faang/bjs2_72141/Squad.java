package school.faang.bjs2_72141;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Getter
public class Squad {
    private final String name;
    private final List<Warrior> squad;
    private int totalSquadPower;

    public void calculateSquadPower() {
        this.totalSquadPower = this.squad.stream()
                .mapToInt(Warrior::getPower)
                .sum();
    }
}
