package school.faang.bjs2_72588;

import java.util.ArrayList;
import java.util.List;

public class Squad {
    private List<Character> characters = new ArrayList<>();

    public Squad(List<Character> characters) {
        if (characters != null) {
            this.characters = characters;
        }
    }

    public int calculateSquadPower() {
        return characters.stream()
            .mapToInt(Character::getPower)
            .sum();
    }
}
