package school.faang.armyofheroes;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class Squad {

    private final String nameOfSquad;
    private final List<Warrior> warriors;

    public int calculateSquadPower() {
        return warriors.stream().mapToInt(Warrior::getPower).sum();
    }
}
