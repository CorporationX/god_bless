package school.faang.bjs2_61228;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class Squad {

    private String name;
    private List<Character> characters;

    public int calculateSquadPower() {
        return characters.stream()
                .mapToInt(Character::getPower)
                .sum();
    }

}
