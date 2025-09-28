package school.faang.bjs2_91314;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class Squad {

    private final List<Character> squad = new ArrayList<>();
    private final String name;

    public void addCharacter(Character character) {
        squad.add(character);
    }

    public Integer calculateSquadPower() {
        return squad.stream().mapToInt(Character::getPower).sum();
    }
}

