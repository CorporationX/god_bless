package school.faang.armyofheroes;

import java.util.List;

public record Squad(String name, List<Character> characters) {
    public int calculateSquadPower() {
        return characters.stream()
                .mapToInt(Character::getPower).sum();
    }
}
