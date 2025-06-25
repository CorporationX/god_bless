package school.faang.parallelmm;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class Squad {
    private String charName;
    private List<Character> characters;

    public int calculateSquadPower() {
        return characters.stream().mapToInt(Character::getPower).sum();
    }

}
