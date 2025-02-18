package school.faang.BJS2_61135;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class Squad {
    private final String name;
    private final List<Character> characters;

    public int calculateSquadPower() {
        int sumPower = 0;
        for (Character character : characters) {
            sumPower += character.getPower();
        }
        return sumPower;
    }
}
