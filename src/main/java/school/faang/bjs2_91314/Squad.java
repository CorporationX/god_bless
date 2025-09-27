package school.faang.bjs2_91314;

import lombok.AllArgsConstructor;
import java.util.List;

@AllArgsConstructor
public class Squad {

    private final List<Character> squad;

    public Integer calculateSquadPower() {
        return squad.stream().mapToInt(Character::getPower).sum();
    }
}

