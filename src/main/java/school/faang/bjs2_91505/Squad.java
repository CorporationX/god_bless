package school.faang.bjs2_91505;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class Squad {
    private String name;
    private List<Warrior> warriors;

    public void addWarrior(Warrior warrior) {
        warriors.add(warrior);
    }

    public int calculateSquadPower() {
        return warriors.stream()
                .mapToInt(Warrior::getPower)
                .sum();
    }
}
