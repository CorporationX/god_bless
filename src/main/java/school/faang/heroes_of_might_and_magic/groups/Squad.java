package school.faang.heroes_of_might_and_magic.groups;

import lombok.Getter;
import school.faang.heroes_of_might_and_magic.warriors.Warrior;

import java.util.List;

@Getter
public class Squad {

    private final String name;
    private List<Warrior> warriors;

    public Squad(String name, List<Warrior> warriors) {
        this.name = name;
        this.warriors = warriors;
    }

    public int calculateSquadPower() {
        int squadPower = 0;
        for (Warrior warrior : warriors) {
            squadPower += warrior.getPower();
        }
        return squadPower;
    }

}
