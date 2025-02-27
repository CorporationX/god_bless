package school.faang.task61218.army;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Getter
@Setter
@Slf4j
public class Squad {
    private String name;
    private List<Character> squad;

    public Squad(String squadName, List<Character> characters) {
        this.name = squadName;
        this.squad = characters;
    }

    public int calculateSquadPower() {
        int squadPower = squad.stream()
                .mapToInt(Character::getPower).sum();
        log.info(String.valueOf(squadPower));
        return squadPower;
    }
}
