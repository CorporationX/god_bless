package BJS2_61185;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class Squad {
    private final String name;
    private List<Character> characters;

    public int calculateSquadPower() {
        return characters.stream().mapToInt(Character::getPower).sum();
    }
}
