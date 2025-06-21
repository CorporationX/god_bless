package school.faang.army_of_heroes_of_might_and_magic_bjs2_81149;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
public class Squad {
    private String squadName;
    private List<Character> characters;

    public void addSquad(Character character) {
        characters.add(character);
    }

    public int calculateSquadPower() {
        return characters.stream()
                .mapToInt(Character::getPower)
                .sum();
    }
}
