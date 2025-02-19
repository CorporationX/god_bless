package school.faang.threadarmy;

import lombok.AllArgsConstructor;

import java.util.List;

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
