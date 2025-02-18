package task_BJS2_61403;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Squad {
    private CharacterType type;
    private List<Character> characters;

    public int calculateSquadPower() {
        return characters.stream().mapToInt(Character::getPower).sum();
    }
}
