package school.faang.army_of_heroes_of_might_and_magic_bjs2_81149;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class Squad {
    private String squadName;
    private List<Character> characters;

    public int calculateSquadPower() {
        int squadPower = 0;
        for (Character character : characters) {
            squadPower += character.getPower();
        }
        return squadPower;
    }
}
