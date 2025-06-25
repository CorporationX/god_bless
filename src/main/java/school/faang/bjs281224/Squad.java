package school.faang.bjs281224;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class Squad {
    private String name;
    private List<Warrior> warriors;

    public int calculateSquadPower() {
        return warriors.stream()
                .mapToInt(Warrior::getPower)
                .sum();
    }
}